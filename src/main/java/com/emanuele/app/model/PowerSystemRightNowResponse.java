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



}
