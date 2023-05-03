package org.pracainzynierska.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Payment {

    private int id;
    private PaymentType type;
    private int reducedValue;
}
