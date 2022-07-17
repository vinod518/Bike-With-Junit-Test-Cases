package com.org.cts.bike1.service;

import com.org.cts.bike1.model.Bike;
import com.org.cts.bike1.repository.BikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeServiceImp implements BikeService{
    @Autowired
    BikeRepo bikeRepo;
    @Override
    public void createBike(Bike bike) {
        bikeRepo.save(bike);
    }

    @Override
    public void updateBike(Bike bike) {
        bikeRepo.save(bike);
    }

    @Override
    public List<Bike> getAll() {
        List<Bike> lb = bikeRepo.findAll();
        return lb;
    }
    @Override
    public Optional<Bike> getById(Integer modelNo) {
       Optional<Bike> ob = bikeRepo.findById(modelNo);
        return ob;
    }
    @Override
    public String deleteById(Integer modelNo) {
        bikeRepo.deleteById(modelNo);
        return "success";
    }

    @Override
    public String updateNameBasedOnModelNo(Integer modelNo, String name) {
        Optional<Bike> op1 = bikeRepo.findById(modelNo);
        Bike bike = op1.get();
        bike.setName(name);
        bikeRepo.save(bike);
        return "success";
    }
}

