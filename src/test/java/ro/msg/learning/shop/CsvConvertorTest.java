package ro.msg.learning.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.controller.util.CsvConvertor;
import ro.msg.learning.entity.Location;
import ro.msg.learning.entity.Product;
import ro.msg.learning.entity.Stock;
import ro.msg.learning.entity.composite.StockCompositeKey;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by vancer at 3/4/2019
 */

@RunWith(SpringRunner.class)
public class CsvConvertorTest {

    @Test
    public void toCsvTest() throws IOException {

        Stock testStock = new Stock(new StockCompositeKey(new Product(1L), new Location(1L)), 2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        CsvConvertor.toCsv(Stock.class, Arrays.asList(testStock), outputStream);

        assertEquals("1,1,2,\n", outputStream.toString());
    }
}

