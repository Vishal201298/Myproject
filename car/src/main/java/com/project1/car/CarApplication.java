package com.project1.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project1.car.domain.Car;
import com.project1.car.domain.CarRepository;

@SpringBootApplication
public class CarApplication implements CommandLineRunner {
	
	Logger logger = LoggerFactory.getLogger(CarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}
	
	@Autowired
	CarRepository carRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		carRepository.save(new Car("Ford", "Mustang", "Red","ADF-1121", 2021, 59000));
		carRepository.save(new Car("Nissan", "Leaf","White","SSJ-3002", 2019, 29000));
		carRepository.save(new Car("Toyota", "Prius","Silver","KKO-0212", 2020, 39000));
		
		for (Car  car: carRepository.findAll()) {
			logger.info(car.getBrand() +  " " + car.getModel());
			}
	}

}
