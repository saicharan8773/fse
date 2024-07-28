package com.financial.forecasting;

public class ExponentialGrowthModel implements ForecastingModel {
    @Override
    public double calculateFutureValue(double initialValue, double rate, int periods) {
        if (periods <= 0) {
            return initialValue;
        }
        return calculateFutureValue(initialValue * (1 + rate), rate, periods - 1);
    }
}
