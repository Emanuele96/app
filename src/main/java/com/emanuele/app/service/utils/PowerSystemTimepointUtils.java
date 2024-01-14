package com.emanuele.app.service.utils;
import com.emanuele.app.model.PowerSystemTimepoint;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PowerSystemTimepointUtils {

    private PowerSystemTimepointUtils() {
    }

    public static Double calculateAverageOnPropertyName(List<PowerSystemTimepoint> timepoints, String propertyNameGetter) {

        try {
            double sum = 0.0;
            for (PowerSystemTimepoint timepoint : timepoints) {
                Double propertyValue = (Double) PowerSystemTimepoint.class.getMethod(propertyNameGetter).invoke(timepoint);
                sum += propertyValue != null ? propertyValue : 0.0;
            }

            return sum / timepoints.size();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}