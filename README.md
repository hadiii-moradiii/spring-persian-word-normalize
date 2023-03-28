# spring-convert-persian-number
in this project with spring boot try to convert persian number to english number 

# for query param and path variable use :
 @PersianConversion
 
 query param: 
 
    @GetMapping 
    public SampleDto getSample(@PersianConversion @RequestParam(value = "number", required = false) String number,
                               @PersianConversion @RequestParam(value = "fromDate", required = false)
                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
                               @PersianConversion @DateTimeFormat(pattern = "yyyy-MM-dd")
                               @RequestParam(value = "sampleDate", required = false) Date sampleDate,
                               @PersianConversion @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               @RequestParam(name = "fromDateTime", required = false) LocalDateTime fromDateTime,
                               @PersianConversion @RequestParam(value = "amount", required = false) Long amount)
                               
                               
                               
 path variable :


    @GetMapping(value = "{number}")
    public SampleDto pathSample(@PersianConversion @PathVariable(value = "number") String number)
    
# for json body use :

@JsonDeserialize

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