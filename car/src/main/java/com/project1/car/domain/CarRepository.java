package com.project1.car.domain;
import org.springframework.data.repository.CrudRepository;

import com.project1.car.domain.Car;

public interface CarRepository extends CrudRepository<Car,Long> {

}
