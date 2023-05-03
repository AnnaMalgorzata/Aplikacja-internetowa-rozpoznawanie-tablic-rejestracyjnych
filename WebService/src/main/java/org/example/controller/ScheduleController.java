package org.example.controller;

import org.example.model.Schedule;
import org.example.model.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @PostMapping("/schedule")
    public int scheduleAdd(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return savedSchedule.getId();
    }
}