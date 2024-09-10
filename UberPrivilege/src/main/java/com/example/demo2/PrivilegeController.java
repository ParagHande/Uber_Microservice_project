package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
	
	@Autowired
	PrivilegeRepo privilegeRepo;
	
	@PostMapping("/savePrivilege")
	public Privilege savePrivilege(@RequestBody Privilege privilege) {
		return privilegeRepo.save(privilege);
	}
	
	@GetMapping("/getPrivilege/{id}")
	public Privilege getPrivilege(@PathVariable Integer id) {
		return privilegeRepo.findById(id).get();
	}

}
