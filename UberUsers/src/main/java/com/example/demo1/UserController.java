package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable Integer id) {
		return userRepo.findById(id).get();
	}
	
	public ResponseEntity<UserDriver> fallbackMethod123 (Exception e){
			String s1 = "Driver Service is down...!! \n Please try after some time";
			return new ResponseEntity(s1, HttpStatus.OK);
	}
	
	@CircuitBreaker(name = "UberCB", fallbackMethod = "fallbackMethod123")
	@GetMapping("/getUserAndDriver/{id}")
	public ResponseEntity<UserDriver> getUserDriver(@PathVariable Integer id) {
		UserDriver userDriver = new UserDriver();
		
		User u1 = userRepo.findById(id).get();
		userDriver.setUser(u1);
		
		RestTemplate rt = new RestTemplate();
		Integer driverId = u1.getDriver_id();
		Driver d1 = rt.getForObject("http://localhost:2580/driver/getDriver/"+driverId, Driver.class);
		userDriver.setDriver(d1);
		
		return ResponseEntity.ok(userDriver);
	}
	
	
	@GetMapping("/getAll/{id}")
	public UserDriverPrivilege getUserDriverPrivilege(@PathVariable Integer id) {
		UserDriverPrivilege userDriverPrivilege = new UserDriverPrivilege();
		
		User u1 = userRepo.findById(id).get();
		userDriverPrivilege.setUser(u1);
		
		RestTemplate rt = new RestTemplate();
		
		Integer driverId = u1.getDriver_id();
		Driver d1 = rt.getForObject("http://localhost:1020/driver/getDriver/"+driverId, Driver.class);
		userDriverPrivilege.setDriver(d1);
		
		Integer privilegeId = u1.getPrivilege_id();
		Privilege p1 = rt.getForObject("http://localhost:1030/privilege/getPrivilege/"+privilegeId, Privilege.class);
		userDriverPrivilege.setPrivilege(p1);
		
		return userDriverPrivilege;
		
	}
	
	
	
	

}
