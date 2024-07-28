package com.financial.forecasting;

public class ForecastingManager {
    private ForecastingModel model;

    public ForecastingManager(ForecastingModel model) {
        this.model = model;
    }

    public double predictFutureValue(double initialValue, double rate, int periods) {
        return model.calculateFutureValue(initialValue, rate, periods);
    }
}
