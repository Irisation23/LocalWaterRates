package com.nhnacademy.localwaterrates.repository;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public interface BillRepository {
    @Autowired
    void loadBills(String path) throws IOException;
    List<WaterBill> findAllBills();
}
