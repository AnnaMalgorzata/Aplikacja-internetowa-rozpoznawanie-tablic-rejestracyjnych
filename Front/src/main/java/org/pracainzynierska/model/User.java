package org.pracainzynierska.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class User {

    private int id;
    private String firstName; //th:field="*{fistName}" - registrationUser.html -musi się zgadzać nazwa
    private String lastName;
    private int age;
    private String email;
    private String username;
    private String password;
    private boolean isAdmin;
}
