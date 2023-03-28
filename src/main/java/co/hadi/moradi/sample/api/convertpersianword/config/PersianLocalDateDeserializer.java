package co.hadi.moradi.sample.api.convertpersianword.config;

import co.hadi.moradi.sample.api.convertpersianword.utils.PersianTextUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class PersianLocalDateDeserializer extends StdDeserializer<LocalDate> {

    public PersianLocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = PersianTextUtils.normalizeString(_parseString(p, ctxt));
        return LocalDate.parse(date);
    }

}