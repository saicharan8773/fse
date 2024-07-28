package com.financial.forecasting;

public class Main {
    public static void main(String[] args) {
        double initialValue = 1000.0; // Example initial value
        double growthRate = 0.05; // Example annual growth rate (5%)
        int periods = 10; // Number of periods (years)

        // Using Exponential Growth Model
        ForecastingModel exponentialModel = new ExponentialGrowthModel();
        ForecastingManager exponentialManager = new ForecastingManager(exponentialModel);
        double exponentialFutureValue = exponentialManager.predictFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value using Exponential Growth Model after " + periods + " periods: " + exponentialFutureValue);

        // Using Compound Interest Model
        ForecastingModel compoundModel = new CompoundInterestModel();
        ForecastingManager compoundManager = new ForecastingManager(compoundModel);
        double compoundFutureValue = compoundManager.predictFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value using Compound Interest Model after " + periods + " periods: " + compoundFutureValue);
    }
}
