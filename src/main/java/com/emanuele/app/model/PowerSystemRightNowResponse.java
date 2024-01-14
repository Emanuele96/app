package com.emanuele.app.model;
import lombok.*;

import java.util.List;
import java.io.Serializable;


@Getter
@Setter
@Builder
public class PowerSystemRightNowResponse  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int total;
    private String dataset;
    @Singular
    private List<PowerSystemTimepoint> records;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PowerSystemRightNowResponse{" +
                "total=" + total +
                ", dataset='" + dataset + '\'' +
                ", records=[");

        if (records != null) {
            for (PowerSystemTimepoint timepoint : records) {
                stringBuilder.append(timepoint.toString()).append(", ");
            }
            // Remove the trailing comma and space
            stringBuilder.setLength(stringBuilder.length() - 2);
        }

        stringBuilder.append("]}");

        return stringBuilder.toString();
    }

    @Getter
    @Setter
    public static class PowerSystemTimepoint  implements Serializable {
        private static final long serialVersionUID = 1L;
        private String minutes1UTC;
        private String minutes1DK;
        private Double co2Emission;
        private Double productionGe100MW;
        private Double productionLt100MW;
        private Double solarPower;
        private Double offshoreWindPower;
        private Double onshoreWindPower;
        private Double exchangeSum;
        private Double exchangeDK1DE;
        private Double exchangeDK1NL;
        private Double exchangeDK1GB;
        private Double exchangeDK1NO;
        private Double exchangeDK1SE;
        private Double exchangeDK1DK2;
        private Double exchangeDK2DE;
        private Double exchangeDK2SE;
        private Double exchangeBornholmSE;


        @Override
        public String toString(){
            return "PowerSystemTimepoint{" +
                    "minutes1UTC='" + minutes1UTC + '\'' +
                    ", minutes1DK='" + minutes1DK + '\'' +
                    ", co2Emission=" + co2Emission +
                    ", productionGe100MW=" + productionGe100MW +
                    ", productionLt100MW=" + productionLt100MW +
                    ", solarPower=" + solarPower +
                    ", offshoreWindPower=" + offshoreWindPower +
                    ", onshoreWindPower=" + onshoreWindPower +
                    ", exchangeSum=" + exchangeSum +
                    ", exchangeDK1DE=" + exchangeDK1DE +
                    ", exchangeDK1NL=" + exchangeDK1NL +
                    ", exchangeDK1GB=" + exchangeDK1GB +
                    ", exchangeDK1NO=" + exchangeDK1NO +
                    ", exchangeDK1SE=" + exchangeDK1SE +
                    ", exchangeDK1DK2=" + exchangeDK1DK2 +
                    ", exchangeDK2DE=" + exchangeDK2DE +
                    ", exchangeDK2SE=" + exchangeDK2SE +
                    ", exchangeBornholmSE=" + exchangeBornholmSE +

                    '}';
        }
    }

}
