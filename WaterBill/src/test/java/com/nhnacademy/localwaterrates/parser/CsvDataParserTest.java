package com.nhnacademy.localwaterrates.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.nhnacademy.localwaterrates.repository.WaterBill;
import java.util.List;
import org.junit.jupiter.api.Test;

class CsvDataParserTest {

    @Test
    void parseTest() {
        List<WaterBill> waterBillList;
        CsvDataParser csvDataParser = new CsvDataParser();
        waterBillList = csvDataParser.parse("Data/Tariff_20220331.csv");

        assertThat(waterBillList.size()).isEqualTo(303);
    }
}