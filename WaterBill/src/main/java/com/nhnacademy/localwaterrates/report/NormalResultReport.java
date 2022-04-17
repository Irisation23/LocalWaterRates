package com.nhnacademy.localwaterrates.report;

import com.nhnacademy.localwaterrates.repository.WaterBill;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class NormalResultReport implements ResultReport {
    private static final Log log = LogFactory.getLog(NormalResultReport.class);

    @Override
    public void report(List<WaterBill> waterBillList, int waterUsageRates) {
        log.info(setReport(waterBillList,waterUsageRates));
    }

    @Override
    public String setReport(List<WaterBill> waterBillList, int waterUse) {

        String message = "\n";
        for (int i = 0; i < waterBillList.size(); i++) {
            String city = waterBillList.get(i).getCity();
            String sector = waterBillList.get(i).getSector();
            int unitPrice = waterBillList.get(i).getUnitPrice();
            int usePrice = waterBillList.get(i).getUnitPrice() * waterUse;
            message += "WaterBill{city=' " + city + "', sector='" + sector + "', unitPrice=" + unitPrice + ", billTotal=" + usePrice + " }\n";
        }
        System.out.println(message);
        return message;
    }
}
