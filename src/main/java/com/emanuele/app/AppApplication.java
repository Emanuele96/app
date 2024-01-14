package com.emanuele.app;
import com.emanuele.app.model.PowerSystemTimepoint;
import com.emanuele.app.rest.ApiService;
import com.emanuele.app.service.DataProcessorService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
import com.emanuele.app.service.DataProcessorService.*;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private ApiService apiService;
	private static Logger LOG = LoggerFactory
			.getLogger(AppApplication.class);

	@Autowired
	private DataProcessorService dataProcessorService;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception{
		LOG.info("\n\n\n\n Starting the application \n\n");

		Observable.interval(3, TimeUnit.SECONDS, Schedulers.io())
				.observeOn(Schedulers.newThread())
				.map(tick -> apiService.getPowerSystemStatus(5, 0, "Minutes1UTC DESC"))
				.doOnError(error -> LOG.error(error.toString()))
				.retry()
				.subscribe(apiObservable -> apiObservable.subscribe(apiResponse -> {
					PowerSystemTimepoint averagePoint = dataProcessorService.calculateAveragePowerSystemValues(apiResponse.getRecords());
					LOG.info("Fetched average energy data: {} ", averagePoint);
					try {
						dataProcessorService.saveDataPoint(averagePoint);
					} catch (Exception e){
						LOG.error("Could not save the datapoint to the db");
						e.printStackTrace();

					}
				}));

		Thread.sleep(Long.MAX_VALUE);

		LOG.info("\n\n\t\t\t Shutting down... ");

	}
}
