package com.org.cts.bike1.service;

import com.org.cts.bike1.model.Bike;
import com.org.cts.bike1.repository.BikeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BikeServiceImpTest {
    @InjectMocks
    BikeServiceImp bikeServiceImp;
    @Mock
    BikeRepo bikeRepo;
    @Test
    void createBike() {
        int modelNo=150;
        String name="pulsar";
        String color="red";
        int noOfwheels= 2;
        Bike bike = new Bike();
        bike.setModelNo(150);
        bike.setName("pulsar");
        bike.setColour("red");
        bike.setNoOfWheels(2);
        bikeServiceImp.createBike(bike);
        Mockito.verify(bikeRepo,Mockito.times(1)).save(bike);

    }

    @Test
    void updateBike() {
        int modelNo=150;
        String name="pulsar";
        String color="red";
        int noOfwheels= 2;
        Bike bike = new Bike();
        bike.setModelNo(150);
        bike.setName("pulsar");
        bike.setColour("red");
        bike.setNoOfWheels(2);
        bikeServiceImp.updateBike(bike);
        Mockito.verify(bikeRepo,Mockito.times(1)).save(bike);
    }

    @Test
    void getAll() {
        List<Bike> list = new ArrayList<>();
        int modelNo=150;
        String name="pulsar";
        String color="red";
        int noOfwheels= 2;
        Bike bike = new Bike();
        bike.setModelNo(150);
        bike.setName("pulsar");
        bike.setColour("red");
        bike.setNoOfWheels(2);
        list.add(bike);
        Bike bike1 = new Bike();
        bike1.setModelNo(220);
        bike1.setName("pulsar");
        bike1.setColour("black");
        bike1.setNoOfWheels(2);
        list.add(bike1);
        Mockito.when(bikeRepo.findAll()).thenReturn(list);
        List<Bike> list1 = bikeServiceImp.getAll();
        Assertions.assertEquals(list.size(),list1.size());
    }

    @Test
    void getById() {
        int modelNo=220;
        String name = "pulasr";
        Bike bike = new Bike();
        bike.setModelNo(220);
        bike.setName("pulsar");
        Optional<Bike> optional = Optional.of(bike);
        Mockito.when(bikeRepo.findById(modelNo)).thenReturn(optional);
        Optional<Bike> optional1 =  bikeServiceImp.getById(modelNo);
        Assertions.assertEquals(optional,optional1);
    }

    @Test
    void deleteById() {
        int modelNo=220;
        String str = "success";
        String str1 = bikeServiceImp.deleteById(modelNo);
        Mockito.verify(bikeRepo,Mockito.times(1)).deleteById(modelNo);
        Assertions.assertEquals(str,str1);
    }

    @Test
    void updateNameBasedOnModelNo() {
        int modelNo=150;
        String name="pulsar";
        Bike bike = new Bike();
        bike.setModelNo(150);
        bike.setName("pulsar");
        String str = "success";
        Optional<Bike> optional = Optional.of(bike);
        Mockito.when(bikeRepo.findById(modelNo)).thenReturn(optional);
        String str1 = bikeServiceImp.updateNameBasedOnModelNo(modelNo,name);
        Assertions.assertEquals(str,str1);

    }
}