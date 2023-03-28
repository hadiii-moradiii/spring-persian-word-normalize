package co.hadi.moradi.sample.api.convertpersianword.config;

import co.hadi.moradi.sample.api.convertpersianword.utils.PersianTextUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersianLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    public PersianLocalDateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = PersianTextUtils.normalizeString(_parseString(p, ctxt));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date,formatter);
    }

}