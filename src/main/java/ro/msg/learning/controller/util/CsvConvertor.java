package ro.msg.learning.controller.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ro.msg.learning.entity.Stock;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by vancer at 3/1/2019
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvConvertor {

    /**
     * Convert to POJO from CSV
     *
     * @param tClass      POJO data type
     * @param inputStream the POJOS as inputStream
     * @param <T>         is the type of the POJOs stored in the CSV.
     * @return
     */
    public static <T> List<T> fromCsv(Class<T> tClass, InputStream inputStream) throws IOException {

        CsvMapper mapper = new CsvMapper();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        CsvSchema schema = mapper.schemaFor(tClass);

        String csv = mapper.writer(schema).writeValueAsString(inputStream);

        MappingIterator<T> it = mapper.readerFor(Stock.class).with(schema).readValues(csv);

        return it.readAll();
    }

    /**
     * Convert to CSF from POJO
     *
     * @param tClass       the POJO that is being converted to CSV
     * @param tList        the list of POJOs to be written in the CSV
     * @param outputStream the CSF as OutputStream
     * @param <T>          is  the type of the POJOs stored in the CSV.
     */
    public static <T> void toCsv(Class<T> tClass, List<T> tList, OutputStream outputStream) throws IOException {

        CsvMapper mapper = new CsvMapper();

        CsvSchema schema = mapper.schemaFor(tClass);

        // map the bean with our schema for the writer
        ObjectWriter writer = mapper.writerFor(tClass).with(schema);

        // we write the list of objects, to the output stream
        writer.writeValues(outputStream).writeAll(tList);
    }
}
