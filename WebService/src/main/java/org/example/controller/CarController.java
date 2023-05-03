package org.example.controller;

import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AbonamentRepository abonamentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    List<Car> listAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/licensePlate/{licensePlate}")
    QueryInfo listCarByLicensePlate(@PathVariable(name = "licensePlate") String licensePlate) {
        Car car = carRepository.findByLicensePlate(licensePlate);
        int carId;
        //Schedule schedule;
        int abonamentId;
        int paymentId;
        int userId;

        if(car != null){
            carId = car.getId();
            Schedule schedule = scheduleRepository.findByCarId(carId);

            if(schedule != null) {
                abonamentId = schedule.getAbonamentId();
                paymentId = schedule.getPaymentId();
                userId  = car.getUserId();

                Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);
                Optional<Abonament> abonamentOptional = abonamentRepository.findById(abonamentId);
                Optional<User> userOptional = userRepository.findById(userId);

                QueryInfo info = new QueryInfo();
                info.setCar(car);
                info.setSchedule(schedule);
                info.setAbonament(abonamentOptional.get());
                info.setPayment(paymentOptional.get());
                info.setUser(userOptional.get());

                return info;
            }
        }

        return null;
    }

    @PostMapping("/car")
    public int carAdd(@RequestBody Car car) {
        Car savedCar = carRepository.save(car);
        return savedCar.getId();
    }
}
