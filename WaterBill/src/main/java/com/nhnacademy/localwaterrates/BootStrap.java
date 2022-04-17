package com.nhnacademy.localwaterrates;

import com.nhnacademy.localwaterrates.config.MainConfiguration;
import com.nhnacademy.localwaterrates.report.NormalResultReport;
import com.nhnacademy.localwaterrates.report.ResultReport;
import com.nhnacademy.localwaterrates.repository.NormalBillRepository;
import com.nhnacademy.localwaterrates.repository.WaterBill;
import com.nhnacademy.localwaterrates.service.NormalWaterUsageRatesService;
import com.nhnacademy.localwaterrates.service.WaterUsageRatesService;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

        String fileName = "Data/Tariff_20220331.json";
        NormalBillRepository normalBillRepository = context.getBean("normalBillRepository",NormalBillRepository.class);
        WaterUsageRatesService waterUsageRatesService = context.getBean("normalWaterUsageRatesService", NormalWaterUsageRatesService.class);
        ResultReport resultReport = context.getBean("normalResultReport", NormalResultReport.class);
        normalBillRepository.loadBills(fileName);
        int waterUsageRates = scanner.nextInt();
        List<WaterBill> waterBillList = waterUsageRatesService.find5CitiesWaterBillByWaterUsageRates(waterUsageRates);
        resultReport.report(waterBillList,waterUsageRates);

    }
}
