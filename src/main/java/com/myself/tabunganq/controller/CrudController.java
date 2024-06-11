package com.myself.tabunganq.controller;

import com.myself.tabunganq.model.ActivityModel;
import com.myself.tabunganq.service.ActivityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "CRUD", description = "CRUD Controller")
public class CrudController {

    private final ActivityService activityService;

    @Autowired
    public CrudController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/insert-activity")
    public ResponseEntity<?> insertActivity(@Valid @RequestBody ActivityModel activityModel) {
        log.info("[Request Received][{} - insertActivity][{}]", this.getClass().getSimpleName(), activityModel);
        activityService.insertActivity(activityModel);
        return new ResponseEntity<>(activityModel, HttpStatus.OK);
    }
}
