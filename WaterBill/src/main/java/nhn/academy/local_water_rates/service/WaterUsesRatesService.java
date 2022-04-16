package nhn.academy.local_water_rates.service;

public interface WaterUsesRatesService {
    void load(String path);
    void findWaterAmountsAccordingToUsage(int waterUsageAmounts);
}
