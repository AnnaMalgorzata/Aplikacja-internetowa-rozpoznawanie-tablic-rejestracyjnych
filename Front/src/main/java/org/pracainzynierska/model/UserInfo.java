package org.pracainzynierska.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String username;

    private String licensePlate;
    private String manufacturer;
    private String brand;

    private String abonamentType;
    private String priority;
    private Date startDate;
    private Date endDate;

    private String paymentType;
    private int reducedValue;
}
