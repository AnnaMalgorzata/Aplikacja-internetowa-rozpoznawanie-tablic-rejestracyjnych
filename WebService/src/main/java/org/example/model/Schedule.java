package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CAR_ID")
    private int carId;

    @Column(name = "ABONAMENT_ID")
    private int abonamentId;

    @Column(name = "PAYMENT_ID")
    private int paymentId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;


}
