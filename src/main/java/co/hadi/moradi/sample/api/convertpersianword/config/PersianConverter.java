package co.hadi.moradi.sample.api.convertpersianword.config;

import co.hadi.moradi.sample.api.convertpersianword.utils.PersianTextUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Component
public class PersianConverter implements ConditionalGenericConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        // Verify whether the annotation is present
        return targetType.getAnnotation(PersianConversion.class) != null;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> hashSet = new HashSet<>();
        hashSet.add(new ConvertiblePair(String.class, String.class));
        hashSet.add(new ConvertiblePair(String.class, LocalDate.class));
        hashSet.add(new ConvertiblePair(String.class, LocalDateTime.class));
        return hashSet;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        // Conversion logic here
        // In this example it strips "value" from the source string
        if (targetType.getType() == String.class) {
            return PersianTextUtils.normalizeString(source.toString());
        } else if (targetType.getType() == LocalDate.class) {
            String normalizeString = PersianTextUtils.normalizeString(source.toString());
            return LocalDate.parse(normalizeString);
        } else if (targetType.getType() == LocalDateTime.class) {
            String normalizeString = PersianTextUtils.normalizeString(source.toString());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(normalizeString, formatter);
        } else {
            return source;
        }
    }


}