package org.pracainzynierska.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Abonament {

    private int id;
    private String name;
    private AbonamentType type;
    private YesNoType priority;
    private YesNoType discount;
    private int multipleCount;

}
