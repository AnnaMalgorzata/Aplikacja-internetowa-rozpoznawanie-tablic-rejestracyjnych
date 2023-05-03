package org.example.model;

import lombok.Data;
import org.example.model.constants.PaymentType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Column(name = "REDUCED_VALUE")
    private int reducedValue;


}
