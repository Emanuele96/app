CREATE TABLE energy_data (
    timestamp TIMESTAMPTZ,
    "CO2Emission" DOUBLE PRECISION,
    "ProductionGe100MW" DOUBLE PRECISION,
    "ProductionLt100MW" DOUBLE PRECISION,
    "SolarPower" DOUBLE PRECISION,
    "OffshoreWindPower" DOUBLE PRECISION,
    "OnshoreWindPower" DOUBLE PRECISION,
    "Exchange_Sum" DOUBLE PRECISION,
    "Exchange_DK1_DE" DOUBLE PRECISION,
    "Exchange_DK1_NL" DOUBLE PRECISION,
    "Exchange_DK1_GB" DOUBLE PRECISION,
    "Exchange_DK1_NO" DOUBLE PRECISION,
    "Exchange_DK1_SE" DOUBLE PRECISION,
    "Exchange_DK1_DK2" DOUBLE PRECISION,
    "Exchange_DK2_DE" DOUBLE PRECISION,
    "Exchange_DK2_SE" DOUBLE PRECISION,
    "Exchange_Bornholm_SE" DOUBLE PRECISION
);
