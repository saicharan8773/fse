package com.financial.forecasting;

public interface ForecastingModel {
    double calculateFutureValue(double initialValue, double rate, int periods);
}
