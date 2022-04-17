package com.nhnacademy.localwaterrates.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.localwaterrates.repository.WaterBill;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("Json")
public class JsonParser implements DataParser{

    @Override
    public List<WaterBill> parse(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        WaterBill[] waterBill = objectMapper.readValue(inputStream, WaterBill[].class);
        return List.of(waterBill);
    }
}
