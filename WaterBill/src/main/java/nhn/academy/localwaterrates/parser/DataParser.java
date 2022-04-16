package nhn.academy.localwaterrates.parser;

import java.util.List;
import nhn.academy.localwaterrates.WaterBill;

//hi
public interface DataParser {
    List<WaterBill> parse(String path);
}
