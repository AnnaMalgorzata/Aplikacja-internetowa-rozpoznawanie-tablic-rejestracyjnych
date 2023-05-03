package org.pracainzynierska.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;
@Data
public class DatabaseQuery {

    private String username;
    private boolean isAdmin;
    private String licensePlate;
    private Date startDate;
    private Date endDate;
    private String abonamentType;
    private String priority;
    private String paymentType;
}
