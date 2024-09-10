package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	DriverRepo driverRepo;
	
	@PostMapping("/saveDriver")
	public Driver saveDriver(@RequestBody Driver driver) {
		return driverRepo.save(driver);
	}
	
	@GetMapping("/getDriver/{id}")
	public Driver getDriver(@PathVariable Integer id) {
		return driverRepo.findById(id).get();
	}

}
