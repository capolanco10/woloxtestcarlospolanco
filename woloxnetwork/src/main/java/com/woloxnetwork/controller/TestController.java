/**
 * @autor CACP - 20/11/2020
 */
package com.woloxnetwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woloxnetwork.domain.service.impl.UsersServiceImpl;
import com.woloxnetwork.dto.Users;

import io.swagger.annotations.ApiOperation;

/**
 * @autor luxos CACP - 11/05/2021
 */
@RestController
@RequestMapping(path = "/api/v1/testcontroller")
@Validated
@CrossOrigin(origins = "*")
public class TestController {
	
	@Autowired
	private UsersServiceImpl service;
	
	@ApiOperation(value = "Get all users", response = Users.class)
	@GetMapping(value = "/getalldata", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> getAllData() throws Exception{
		return new ResponseEntity<>(service.getAllData(), HttpStatus.OK);
	}

	@ApiOperation(value = "Get user for Id ", response = Users.class)
	@GetMapping(value = "/getdataid/{id}", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> getDataId(@Valid @PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(service.getDataId(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Create users", response = Users.class)
	@PostMapping(value = "/create", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> createData(@Valid @RequestBody Users post) throws Exception{
		return new ResponseEntity<>(service.createData(post), HttpStatus.OK);
	}

	@ApiOperation(value = "Update user", response = Users.class)
	@PutMapping(value = "/update", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> updateData(@Valid @RequestBody Users post) throws Exception{
		return new ResponseEntity<>(service.updateData(post), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete user for Id", response = Users.class)
	@DeleteMapping(value = "/deleteId/{id}", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> deleteId(@Valid @PathVariable Integer id) throws Exception{
		service.deleteData(id);
		return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
	}
}
