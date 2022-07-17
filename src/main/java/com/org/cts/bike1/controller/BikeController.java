package com.org.cts.bike1.controller;

import com.org.cts.bike1.model.Bike;
import com.org.cts.bike1.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BikeController {
    @Autowired
    BikeService bikeService;
    @PostMapping("/create")
    public void createBike(@RequestBody Bike bike){
        bikeService.createBike(bike);
    }
    @PostMapping("/update")
    public void updateBike(@RequestBody Bike bike){
        bikeService.updateBike(bike);
    }
    @GetMapping("/getAll")
    public List<Bike> getAll(){
        List<Bike> lb = bikeService.getAll();

        return lb;
    }
    @GetMapping("/getById/{modelNo}")
    public Optional<Bike> getById(@PathVariable Integer modelNo){
        Optional<Bike>  ob = bikeService.getById(modelNo);
        return ob;
    }
    @DeleteMapping("/deleteById/{modelNo}")
    public String deleteById(@PathVariable Integer modelNo){
        bikeService.deleteById(modelNo);
        return "success";
    }
    @PatchMapping("/updateNameBasedOnModelNo/{modelNo}/{name}")
    public String updateNameBasedOnModel(@PathVariable Integer modelNo, @PathVariable String name){
        String s = bikeService.updateNameBasedOnModelNo(modelNo,name);
        return "s";
    }
}
