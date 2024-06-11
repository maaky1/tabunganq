package com.myself.tabunganq.controller;

import com.myself.tabunganq.model.ActivityModel;
import com.myself.tabunganq.service.ActivityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@Tag(name = "CRUD", description = "CRUD Controller")
public class CrudController {

    private final ActivityService activityService;

    @Autowired
    public CrudController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("data", new ActivityModel());
        return "index";
    }

    @PostMapping("/insert")
    public String insert(ActivityModel data) {
        log.info("[Request Received][{} - insertActivity][{}]", this.getClass().getSimpleName(), data);
        activityService.insertActivity(data);
        return "redirect:/";
    }

    @PostMapping("/insert-activity")
    public ResponseEntity<?> insertActivity(@Valid @RequestBody ActivityModel activityModel) {
        log.info("[Request Received][{} - insertActivity][{}]", this.getClass().getSimpleName(), activityModel);
        activityService.insertActivity(activityModel);
        return new ResponseEntity<>(activityModel, HttpStatus.OK);
    }
}
