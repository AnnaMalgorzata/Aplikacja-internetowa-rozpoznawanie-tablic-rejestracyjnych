package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cars")
public class Car {

    /*
        żeby tabela powstała musi być encja (folder model - zazwyczaj odnosi się do bazy danych)
        nasza encja - rzecz. w liczbie poj. - klasa Car (@Entity - informuje hibernate,
        żeby z klasy car zrobił tablę o nazwie "cars" - @Table(name="cars"))
        orm - mapujemy obiekt java na tabelę bazy danych
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "license_plate")
    private String licensePlate;

    private String manufacturer;

    private String brand;

    @Column(name = "user_id")
    private int userId;
}
