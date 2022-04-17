package com.nhnacademy.localwaterrates.parser;

import com.nhnacademy.localwaterrates.repository.WaterBill;
import java.io.IOException;
import java.util.List;

public interface DataParser {
    List<WaterBill> parse(String path) throws IOException;
}
