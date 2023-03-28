package co.hadi.moradi.sample.api.convertpersianword.contoller;

import co.hadi.moradi.sample.api.convertpersianword.config.PersianConversion;
import co.hadi.moradi.sample.api.convertpersianword.dto.SampleDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("${v1API}/sample")
public class SampleController {


    @GetMapping
    public SampleDto getSample(@PersianConversion @RequestParam(value = "number", required = false) String number,
                               @PersianConversion @RequestParam(value = "fromDate", required = false)
                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
                               @PersianConversion @DateTimeFormat(pattern = "yyyy-MM-dd")
                               @RequestParam(value = "sampleDate", required = false) Date sampleDate,
                               @PersianConversion @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               @RequestParam(name = "fromDateTime", required = false) LocalDateTime fromDateTime,
                               @PersianConversion @RequestParam(value = "amount", required = false) Long amount) {

        return SampleDto.builder()
                .amount(amount)
                .date(fromDate)
                .number(number)
                .fromDateTime(fromDateTime)
                .sampleDate(sampleDate)
                .build();

    }

    @GetMapping(value = "{number}")
    public SampleDto pathSample(@PersianConversion @PathVariable(value = "number") String number) {

        return SampleDto.builder()
                .number(number)
                .build();

    }

    @PostMapping
    public SampleDto postSample(@RequestBody SampleDto sampleDto) {
        return sampleDto;

    }
}