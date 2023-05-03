package org.pracainzynierska.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class Car {

    private int id;
    private String licensePlate;
    private String manufacturer;
    private String brand;
    private int userId;
}
