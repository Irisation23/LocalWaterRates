package nhn.academy.localwaterrates.service;

public interface WaterUsageRatesService {
    void load(String path);
    void findWaterAmountsAccordingToUsage(int waterUsageAmounts);
}
