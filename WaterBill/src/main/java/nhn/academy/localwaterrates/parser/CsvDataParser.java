package nhn.academy.localwaterrates.parser;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import nhn.academy.localwaterrates.WaterBill;

public class CsvDataParser implements DataParser{
    private final List<WaterBill> waterBillList = new ArrayList<>();

    @Override
    public List<WaterBill> parse(String path) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line = "";

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
