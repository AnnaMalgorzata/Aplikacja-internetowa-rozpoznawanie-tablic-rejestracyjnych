package org.pracainzynierska.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class ScheduleHelperBean {

    private AbonamentType abonamentType;
    private YesNoType priority;
    private YesNoType discount;
    private int multipleCount;

    private PaymentType paymentType;
    private int reducedValue;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

}
