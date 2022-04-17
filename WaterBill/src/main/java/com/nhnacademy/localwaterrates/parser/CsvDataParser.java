package com.nhnacademy.localwaterrates.parser;

import static java.lang.Integer.parseInt;

import com.nhnacademy.localwaterrates.repository.WaterBill;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvDataParser implements DataParser {

    @Override
    public List<WaterBill> parse(String path) {
        List<WaterBill> waterBillList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)))) {
            String line = "";
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] token = line.split(",");
                waterBillList.add(new WaterBill(parseInt(token[0]), token[1], token[2],parseInt(token[3]),parseInt(token[4]),parseInt(token[5]),parseInt(token[6])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return waterBillList;
    }
}
