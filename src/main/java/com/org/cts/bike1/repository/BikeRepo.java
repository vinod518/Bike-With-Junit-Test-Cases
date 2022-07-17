package com.org.cts.bike1.repository;

import com.org.cts.bike1.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepo extends JpaRepository<Bike,Integer> {
}
