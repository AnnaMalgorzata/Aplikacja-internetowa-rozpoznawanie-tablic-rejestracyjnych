package org.example.controller;

import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/user_by_username/{username}")
    @ResponseBody
    public User userByUsername(@PathVariable("username") String username) {
        User user = userRepository.findUserByUsername(username);
        return user;
    }

    @GetMapping("/user_if_admin/{username}")
    @ResponseBody
    public boolean userIfAdmin(@PathVariable("username") String username) {
        User user = userRepository.findUserByUsername(username);
        return user.isAdmin();
    }

    @PostMapping("/user")
    public int userAdd(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    //ws który służy do pobrania usera za pomocą ajdikia
    @GetMapping("/user/{id}")
    @ResponseBody
    public User userGet(@PathVariable("id") int id) {
        User user = userRepository.getById(id);
        return user;
    }

    @GetMapping("/user_info/{userId}")
    @ResponseBody
    public UserInfo getUserInfo(@PathVariable("userId") int userId) {
        List<UserInfo> userInfoList = jdbcTemplate.query("SELECT \n" +
                "u.FIRST_NAME, u.LAST_NAME, u.AGE, u.EMAIL, u.USERNAME, " +
                "c.LICENSE_PLATE, c.MANUFACTURER, c.BRAND," +
                "a.TYPE as \"ABONAMENT_TYPE\", a.PRIORITY, s.START_DATE, s.END_DATE,  " +
                "p.TYPE as \"PAYMENT_TYPE\", p.REDUCED_VALUE " +
                "FROM\n" +
                " Cars c, Users u, Schedules s, Abonaments a, Payments p\n" +
                "WHERE \n" +
                "c.USER_ID= " + userId + " \n" +
                "and c.USER_ID=u.ID \n" +
                "and s.CAR_ID=c.ID \n" +
                "and s.ABONAMENT_ID=a.ID\n" +
                "and s.PAYMENT_ID=p.ID",
                (rs, rowNum) ->
                    new UserInfo(
                            rs.getString("first_name"), //nazwy takie jak w zapytaniu ALE wielkość liter nie ma tu znaczenia
                            rs.getString("last_name"),
                            rs.getInt("age"),
                            rs.getString("email"),
                            rs.getString("username"),
                            rs.getString("license_plate"),
                            rs.getString("manufacturer"),
                            rs.getString("brand"),
                            rs.getString("abonament_type"),
                            rs.getString("priority"),
                            rs.getDate("start_date"),
                            rs.getDate("end_date"),
                            rs.getString("payment_type"),
                            rs.getInt("reduced_value")
                    )
        );

        if (userInfoList.size() > 0) {
            return userInfoList.get(0);
        } else {
            return new UserInfo();
        }
    }



    @GetMapping("/database_query")
    @ResponseBody
    public List<DatabaseQuery> databaseQueryGet() {
        return jdbcTemplate.query("SELECT \n" +
                        "u.USERNAME, u.IS_ADMIN, c.LICENSE_PLATE, s.START_DATE, s.END_DATE, a.TYPE as \"ABONAMENT_TYPE\", a.PRIORITY, p.TYPE as \"PAYMENT_TYPE\"\n" +
                        "FROM\n" +
                        " CARS c, USERS u, SCHEDULES s, ABONAMENTS a, PAYMENTS p\n" +
                        "WHERE \n" +
                        "c.USER_ID=u.ID \n" +
                        "and s.CAR_ID=c.ID \n" +
                        "and s.ABONAMENT_ID=a.ID\n" +
                        "and s.PAYMENT_ID=p.ID",
                (rs, rowNum) ->
                        new DatabaseQuery(
                                rs.getString("username"),
                                rs.getBoolean("is_admin"),
                                rs.getString("license_plate"),
                                rs.getDate("start_date"),
                                rs.getDate("end_date"),
                                rs.getString("abonament_type"),
                                rs.getString("priority"),
                                rs.getString("payment_type")

                        )
        );

    }
}