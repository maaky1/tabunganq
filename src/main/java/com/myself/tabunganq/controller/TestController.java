package com.myself.tabunganq.controller;

import com.myself.tabunganq.entity.ActivityEntity;
import com.myself.tabunganq.repository.ActivityRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "testing", description = "testing")
public class TestController {

    private final ActivityRepository activityRepository;

    @Autowired
    public TestController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

//    @GetMapping("/insert")
//    public void cobainsert() {
//        activityRepository.insertData();
//    }

    @GetMapping("/data")
    public ResponseEntity<?> cobaget() {
        ActivityEntity data = activityRepository.getData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
