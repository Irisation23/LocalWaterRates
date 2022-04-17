package com.nhnacademy.localwaterrates.report;

import com.nhnacademy.localwaterrates.repository.WaterBill;
import java.util.List;

public interface ResultReport {
    void report(List<WaterBill> waterBillList, int waterUsageRates);
    String setReport(List<WaterBill> waterBillList, int waterUsageRates);
}
