package org.pracainzynierska.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private long fileSize;

    /*
    @Lob - w linijce niżej delklaracja czy byte czy char; byte bo zapisywany jest plik;
    blob i clob stosowane poniważ bazy danych nie mają czegoś takiego jak tablice
     */
//    @Lob
//    private byte[] file;

    @Column(name="license_plate")
    private String licensePlate;
}