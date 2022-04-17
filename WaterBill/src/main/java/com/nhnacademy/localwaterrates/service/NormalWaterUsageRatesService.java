package com.nhnacademy.localwaterrates.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.nhnacademy.localwaterrates.repository.WaterBill;
import com.nhnacademy.localwaterrates.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NormalWaterUsageRatesService implements WaterUsageRatesService {
    private BillRepository billRepository;

    @Autowired
    public NormalWaterUsageRatesService(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    @Override
    public List<WaterBill> find5CitiesWaterBillByWaterUsageRates(int waterUsageRates) {
        return billRepository.findAllBills().stream().
            filter(waterBill -> waterBill.getUnitStart() <= waterUsageRates && waterBill.getUnitEnd() >= waterUsageRates).
            sorted(Comparator.comparing(WaterBill::getUnitPrice)).
            limit(5).
            collect(Collectors.toList());
    }
}
