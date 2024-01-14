package com.emanuele.app.model;

import jdk.jfr.Timestamp;
import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;

import com.emanuele.app.model.interfaces.TimescaleTable;
@Getter
@Setter
@Entity
@Table(name = PowerSystemTimepoint.tableName)
@TimescaleTable(tableName = PowerSystemTimepoint.tableName, timeColumnName = PowerSystemTimepoint.timeColumnName)
@IdClass(PowerSystemTimepoint.PowerSystemTimepointId.class)

public class PowerSystemTimepoint  implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String tableName = "energy_data";
    public static final String timeColumnName = "timestamp";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Id
    @Column(name = PowerSystemTimepoint.timeColumnName, nullable = false)
    private Long timestamp;
    @Column(nullable = false)
    private Double co2Emission;
    @Column(nullable = false)
    private Double productionGe100MW;
    @Column(nullable = false)
    private Double productionLt100MW;
    @Column(nullable = false)
    private Double solarPower;
    @Column(nullable = false)
    private Double offshoreWindPower;
    @Column(nullable = false)
    private Double onshoreWindPower;
    @Column(nullable = false)
    private Double exchangeSum;
    @Column(nullable = false)
    private Double exchangeDK1DE;
    @Column(nullable = false)
    private Double exchangeDK1NL;
    @Column(nullable = false)
    private Double exchangeDK1GB;
    @Column(nullable = false)
    private Double exchangeDK1NO;
    @Column(nullable = false)
    private Double exchangeDK1SE;
    @Column(nullable = false)
    private Double exchangeDK1DK2;
    @Column(nullable = false)
    private Double exchangeDK2DE;
    @Column(nullable = false)
    private Double exchangeDK2SE;
    @Column(nullable = false)
    private Double exchangeBornholmSE;

    @Data
    public static class PowerSystemTimepointId implements Serializable {
        private Integer id;
        private Long timestamp;
    }

    @Override
    public String toString(){
        return "PowerSystemTimepoint{" +
                "minutes1UTC='" + timestamp + '\'' +
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