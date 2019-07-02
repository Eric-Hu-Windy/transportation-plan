package com.chuckie.transportationplan.controller;

import com.chuckie.transportationplan.model.Plan;
import com.chuckie.transportationplan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Chuckie
 */
@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @PostMapping
    public void create(@RequestBody Plan plan) {
        planService.create(plan);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Plan plan) {
        planService.update(id, plan);
    }

    @PutMapping("/{id}/delete")
    public void delete(@PathVariable int id) {
        planService.delete(id);
    }

    @GetMapping
    public List<Plan> getAll() {
        return planService.getAll();
    }

    @GetMapping("/get-by-date")
    public List<Plan> getByDate(@DateTimeFormat(pattern = "yyyy/MM/dd") Date date) {
        return planService.getByDate(date);
    }

    @GetMapping("/{id}")
    public Plan getByDate(@PathVariable int id) {
        return planService.getById(id);
    }
}
