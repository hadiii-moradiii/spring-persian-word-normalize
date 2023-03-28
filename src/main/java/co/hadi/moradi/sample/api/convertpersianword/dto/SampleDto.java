package co.hadi.moradi.sample.api.convertpersianword.dto;

import co.hadi.moradi.sample.api.convertpersianword.config.PersianLocalDateDeserializer;
import co.hadi.moradi.sample.api.convertpersianword.config.PersianLocalDateTimeDeserializer;
import co.hadi.moradi.sample.api.convertpersianword.config.PersianWordDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SampleDto implements Serializable {

    @JsonDeserialize(using = PersianWordDeserializer.class)
    private String number;
    private Long amount;

    @JsonDeserialize(using = PersianLocalDateDeserializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Tehran")
    private LocalDate date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Tehran")
    private Date sampleDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tehran")
    @JsonDeserialize(using = PersianLocalDateTimeDeserializer.class)
    private LocalDateTime fromDateTime;

}
