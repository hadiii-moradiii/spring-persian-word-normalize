package co.hadi.moradi.sample.api.convertpersianword.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class CustomLocalDateDeserializer extends LocalDateDeserializer {

    public CustomLocalDateDeserializer() {
        super();
    }
}
