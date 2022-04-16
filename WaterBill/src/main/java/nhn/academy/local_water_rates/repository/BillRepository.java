package nhn.academy.local_water_rates.repository;

public interface BillRepository {
    void load(String path);
    void findBillByUse(int waterUsageRates);
}
