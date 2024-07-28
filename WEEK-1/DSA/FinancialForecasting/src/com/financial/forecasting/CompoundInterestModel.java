package com.financial.forecasting;

public class CompoundInterestModel implements ForecastingModel {
    @Override
    public double calculateFutureValue(double initialValue, double rate, int periods) {
        return initialValue * Math.pow(1 + rate, periods);
    }
}
