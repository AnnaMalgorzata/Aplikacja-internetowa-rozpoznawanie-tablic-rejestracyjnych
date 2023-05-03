package org.pracainzynierska.component;

import org.pracainzynierska.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Component
public class WSClient {

    //do komunikowania się z WS
    public static final String URL_WS = "http://localhost:8085";

    RestTemplate restTemplate = new RestTemplate();

    public List<Car> getAllCars() {
        ResponseEntity<Car[]> response = restTemplate.getForEntity(URL_WS, Car[].class);
        return Arrays.asList(response.getBody());
    }

    public QueryInfo getCarByLicensePlate(String licensePlate) {
        ResponseEntity<QueryInfo> response = restTemplate.getForEntity(URL_WS + "/licensePlate/" + licensePlate, QueryInfo.class);
        return response.getBody();
    }

    public int saveUser(User user) {
        ResponseEntity<Integer> response = restTemplate.postForEntity(URL_WS + "/user", user, Integer.class );
        return response.getBody();
    }

    public User getUser(int userId) {
        ResponseEntity<User> response = restTemplate.getForEntity(URL_WS + "/user/" + userId, User.class);
        return response.getBody();
    }

    public int saveCar(Car car) {
        ResponseEntity<Integer> response = restTemplate.postForEntity(URL_WS + "/car", car, Integer.class );
        return response.getBody();
    }

    public int saveAbonament(Abonament abonament) {
        ResponseEntity<Integer> response = restTemplate.postForEntity(URL_WS + "/abonament", abonament, Integer.class );
        return response.getBody();
    }

    public int savePayment(Payment payment) {
        ResponseEntity<Integer> response = restTemplate.postForEntity(URL_WS + "/payment", payment, Integer.class );
        return response.getBody();
    }

    public int saveSchedule(Schedule schedule) {
        ResponseEntity<Integer> response = restTemplate.postForEntity(URL_WS + "/schedule", schedule, Integer.class );
        return response.getBody();
    }

    public List<DatabaseQuery> getDataBase() {
        ResponseEntity<DatabaseQuery[]> response = restTemplate.getForEntity(URL_WS + "/database_query", DatabaseQuery[].class );
        return Arrays.asList(response.getBody());
    }

    public User findUserByUsername(String username) {
        ResponseEntity<User> response = restTemplate.getForEntity(URL_WS + "/user_by_username/" + username, User.class);
        return response.getBody();
    }

    public boolean checkIfUserAdmin(String username) {
        ResponseEntity<Boolean> response = restTemplate.getForEntity(URL_WS + "/user_if_admin/" + username, Boolean.class);
        return response.getBody();
    }

    public UserInfo getUserInfoDataById(int userId) {
        ResponseEntity<UserInfo> response = restTemplate.getForEntity(URL_WS + "/user_info/" + userId, UserInfo.class);
        return response.getBody();
    }

}