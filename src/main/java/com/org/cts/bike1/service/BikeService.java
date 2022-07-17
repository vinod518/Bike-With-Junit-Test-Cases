package com.org.cts.bike1.service;

import com.org.cts.bike1.model.Bike;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface BikeService{
    public void createBike( Bike bike);
    public void updateBike( Bike bike);
    public List<Bike> getAll();
    public Optional<Bike> getById( Integer modelNo);
    public String deleteById( Integer modelNo);
    public String updateNameBasedOnModelNo( Integer modelNo,  String name);
}
