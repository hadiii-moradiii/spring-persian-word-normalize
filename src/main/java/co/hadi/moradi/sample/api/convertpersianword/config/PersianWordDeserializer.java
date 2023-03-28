package co.hadi.moradi.sample.api.convertpersianword.config;

import co.hadi.moradi.sample.api.convertpersianword.utils.PersianTextUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class PersianWordDeserializer extends StdDeserializer<String> {

    public PersianWordDeserializer() {
        super(String.class);
    }

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return PersianTextUtils.normalizeString(_parseString(p, ctxt));
    }

}