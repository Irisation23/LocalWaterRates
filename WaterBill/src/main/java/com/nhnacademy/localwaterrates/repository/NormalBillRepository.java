package com.nhnacademy.localwaterrates.repository;

import com.nhnacademy.localwaterrates.parser.DataParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NormalBillRepository implements BillRepository {
    private DataParser dataParser;

    private List<WaterBill> waterBillList = new ArrayList<>();
    static boolean FileLoaded = false;

    @Autowired
    @Qualifier("Json")
    private void DataParser(DataParser dataParser){
        this.dataParser = dataParser;
    }

    public static void isFileLoaded() {
        if (!FileLoaded) {
            throw new IllegalStateException();
        }
    }

    public static void changeValueTrueByLoading(){
        if(!FileLoaded){
            FileLoaded = true;
        }
    }

    @Override
    public void loadBills(String path) throws IOException {
        this.waterBillList = dataParser.parse(path);
        changeValueTrueByLoading();
    }

    @Override
    public List<WaterBill> findAllBills() {
        return this.waterBillList;
    }
}
