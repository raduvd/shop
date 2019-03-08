package ro.msg.learning.controller.util;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.stereotype.Component;
import ro.msg.learning.entity.Stock;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vancer at 3/1/2019
 */
@Component
public class CsvHttpMessageConverter extends AbstractGenericHttpMessageConverter<List<Stock>> {

    public static final MediaType TEXT_CSV_TYPE = new MediaType("text", "csv");

    public CsvHttpMessageConverter() {
        super(TEXT_CSV_TYPE);
    }


    @Override
    protected void writeInternal(List<Stock> stockList, Type type, HttpOutputMessage message) throws IOException {

        OutputStream outputStream = message.getBody();
        CsvConvertor.toCsv(Stock.class, stockList, outputStream);
    }

    @Override
    protected List<Stock> readInternal(Class aClass, HttpInputMessage message) throws IOException {
        return new ArrayList<>();
    }

    @Override
    public List<Stock> read(Type type, Class aClass, HttpInputMessage message) throws IOException {
        return new ArrayList<>();
    }
}
