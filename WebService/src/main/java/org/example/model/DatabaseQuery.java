package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.constants.AbonamentType;
import org.example.model.constants.PaymentType;
import org.example.model.constants.YesNoType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DatabaseQuery {
    //pola jak w zapytaniu kolumny
    private String username;

    private boolean isAdmin;

    private String licensePlate;

    private Date startDate;

    private Date endDate;

    private String abonamentType;

    private String priority;

    private String paymentType;

}
