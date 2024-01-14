package com.emanuele.app;
import com.emanuele.app.service.ApiService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private ApiService apiService;
	private static Logger LOG = LoggerFactory
			.getLogger(AppApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		LOG.info("\n\n\n\n Hello World! \n\n");

		Observable.interval(10, TimeUnit.SECONDS, Schedulers.io())
				.observeOn(Schedulers.newThread())
				.map(tick -> apiService.getPowerSystemStatus())
				.doOnError(error -> LOG.error(error.toString()))
				.retry()
				.subscribe(apiObservable -> apiObservable.subscribe(apiResponse -> LOG.info("Fetched energy data: {} ", apiResponse.toString())));

		Thread.sleep(100000);

		LOG.info("\n\n\t\t\t Shutting down... ");

	}
}
