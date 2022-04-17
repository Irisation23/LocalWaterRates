package com.nhnacademy.localwaterrates.service;

import com.nhnacademy.localwaterrates.repository.WaterBill;
import java.util.List;

public interface WaterUsageRatesService {
    List<WaterBill> find5CitiesWaterBillByWaterUsageRates(int waterUsageRates);

}
