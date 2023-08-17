package org.pracainzynierska.controller;

import org.pracainzynierska.component.WSClient;
import org.pracainzynierska.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private WSClient wsClient;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/registration")
    public String registration(Model model) { 
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/registration_car")
    public String registrationCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);

        System.out.println("Model\nuserId: " + model.getAttribute("userId"));
        System.out.println("carId: " + model.getAttribute("carId"));
        System.out.println("scheduleId: " + model.getAttribute("scheduleId"));
        return "registration";
    }

    @PostMapping("/user")
    public String registrationSaveUser(@ModelAttribute User user, Model model, HttpSession session) {

        String userFirstName = user.getFirstName();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        int userId = wsClient.saveUser(user);

        Car car = new Car();

        model.addAttribute("car", car);
        model.addAttribute("userId", userId);
        session.setAttribute("userId", userId);

        return "registration";
    }

    @PostMapping("/car")
    public String registrationSaveCar(@ModelAttribute Car car, Model model, HttpSession session) {
        car.setUserId((int) session.getAttribute("userId"));

        String licensePlate = car.getLicensePlate();
        char[] plateChars = licensePlate.toCharArray();

        StringBuilder finalPlate = new StringBuilder("");
        for (char c : plateChars) {
            if (Character.isLetterOrDigit(c)) {
                finalPlate.append(c);
            }
        }

        car.setLicensePlate(finalPlate.toString());
        int carId = wsClient.saveCar(car);
        session.setAttribute("carId", carId);
        model.addAttribute("carId", carId);

        ScheduleHelperBean scheduleHelperBean = new ScheduleHelperBean();
        model.addAttribute("scheduleHelperBean", scheduleHelperBean);
        return "registration";
    }

    @PostMapping("/schedule")
    public String registrationSaveSchedule(@ModelAttribute ScheduleHelperBean scheduleHelperBean, Model model, HttpSession session) {
        Abonament abonament = new Abonament();
        Payment payment = new Payment();
        Schedule schedule = new Schedule();
        
        abonament.setDiscount(scheduleHelperBean.getDiscount());
        abonament.setType(scheduleHelperBean.getAbonamentType());
        abonament.setPriority(scheduleHelperBean.getPriority());
        abonament.setMultipleCount(scheduleHelperBean.getMultipleCount());

        int abonamentId = wsClient.saveAbonament(abonament);
        session.setAttribute("priority", abonament.getPriority());

        payment.setType(scheduleHelperBean.getPaymentType());
        payment.setReducedValue(scheduleHelperBean.getReducedValue());

        int paymentId = wsClient.savePayment(payment);

        schedule.setStartDate(scheduleHelperBean.getStartDate());
        schedule.setEndDate(scheduleHelperBean.getEndDate());

        schedule.setAbonamentId(abonamentId);
        schedule.setPaymentId(paymentId);

        schedule.setCarId((int)session.getAttribute("carId"));

        wsClient.saveSchedule(schedule);
        int scheduleId = schedule.getId();

        session.setAttribute("scheduleId", scheduleId);
        model.addAttribute("scheduleId", scheduleId);

        int carId = schedule.getCarId();
        model.addAttribute("carId", carId);
        int userId = (int)session.getAttribute("userId");
        model.addAttribute("userId", userId);

        User user = wsClient.getUser(userId);

        session.setAttribute("admin", user.isAdmin() ? true : false);

        return "home";
    }

    @GetMapping("/infoUser")
    public String infoUser(Model model, HttpSession session) {

        int userId = (int)session.getAttribute("userId");
        UserInfo userInfo = wsClient.getUserInfoDataById(userId);

        if(userInfo.getStartDate() == null && userInfo.getEndDate() == null) {
            User user = wsClient.getUser(userId);
            userInfo.setFirstName(user.getFirstName());
            userInfo.setLastName(user.getLastName());
            userInfo.setAge(user.getAge());
            userInfo.setEmail(user.getEmail());
            userInfo.setUsername(user.getUsername());
        }

        model.addAttribute("userInfo", userInfo);
        model.addAttribute("carInfo", userInfo.getLicensePlate());
        model.addAttribute("abonamentInfo", userInfo.getAbonamentType());
        model.addAttribute("paymentInfo", userInfo.getPaymentType());

        return "infoUser";
    }
}
