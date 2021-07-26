package com.example.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Car;

@RestController
@RequestMapping("/api")
public class CarController {
	
	private final Logger log = LoggerFactory.getLogger(CarController.class);
	
		@GetMapping("/cars")
		public List<Car> findAll(){
			log.info("REST request to find all cars");
			Car car1 = new Car(1L, "Ford", "Mondeo", 1.5, 5);
			Car car2 = new Car(2L, "Toyota", "Prius", 1.5, 5);
			
			return List.of(car1, car2);
		}
		
		
		@GetMapping("/cars/{id}")
		public ResponseEntity<Car> findOne(@PathVariable Long id){
			log.info("REST request to find one car");
			Car car1 = new Car(id, "Ford", "Mondeo", 1.5, 5);

			
			return ResponseEntity.ok(car1);
		}
		
		@PostMapping("/cars")
		public ResponseEntity<Car> create(@RequestBody Car car){
			log.info("REST request to create a new car");
			if(car.getId()!=null) {
				log.warn("Se ha intentado crear con una id");
				return ResponseEntity.badRequest().build();
			}

			car.setId(4L);
			return ResponseEntity.ok(car);
			
		}
		
		
		@PutMapping("/cars")
		public ResponseEntity<Car> edit(@RequestBody Car car){
			log.info("REST request to edit a car");
			if(car.getId()==null) {
				log.warn("Se ha intentado editar sin una id");
				return ResponseEntity.badRequest().build();
			}

			return ResponseEntity.ok(car);
			
		}
		
		
		@DeleteMapping("/cars/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id){
			log.info("REST request to delete a car");
			

			return ResponseEntity.noContent().build();
			
		}
		
		
		@DeleteMapping("/cars")
		public ResponseEntity<Void> deleteAll(){
			log.info("REST request to delete all cars");
			

			return ResponseEntity.noContent().build();
			
		}
}

