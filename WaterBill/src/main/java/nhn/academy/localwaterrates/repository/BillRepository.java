package nhn.academy.localwaterrates.repository;

public interface BillRepository {
    void load(String path);
    void findBillByUse(int waterUsageRates);
}
