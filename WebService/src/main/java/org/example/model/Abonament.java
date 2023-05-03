package org.example.model;

import lombok.Data;
import org.example.model.constants.AbonamentType;
import org.example.model.constants.YesNoType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "abonaments")
public class Abonament {
    /*
        @Data - tworzy gettery, settery, toString etc - w kodzie źródłowym jest to niewidoczne,
                ale zobaczyć można w pliku .class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AbonamentType type;

    @Enumerated(EnumType.STRING)
    private YesNoType priority;

    @Enumerated(EnumType.STRING)
    private YesNoType discount;

    @Column(name = "MULTIPLE_COUNT")
    private int multipleCount;
}
