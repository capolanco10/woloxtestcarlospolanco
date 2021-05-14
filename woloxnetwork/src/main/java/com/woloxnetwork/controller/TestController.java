/**
 * @autor CACP - RFAST9 20/11/2020
 */
package com.woloxnetwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.woloxnetwork.api.WoloxpermissionsApi;
import com.woloxnetwork.domain.service.impl.UsersServiceImpl;
import com.woloxnetwork.domain.service.impl.WoloxpermissionsServiceImpl;
import com.woloxnetwork.dto.Users;

import io.swagger.annotations.ApiOperation;

/**
 * @autor luxos CACP - RFAST9 11/05/2021
 */
@RestController
@RequestMapping(path = "/api/v1/testcontroller")
@Validated
@CrossOrigin(origins = "*")
public class TestController {
	
	@Autowired
	private UsersServiceImpl service;
	
	@Autowired
	private WoloxpermissionsServiceImpl permissionservice;  
	
	@ApiOperation(value = "Obtener informacion detallada de auditoria de proceso de documento electronico", response = Users.class)
	@GetMapping(value = "/getalldata", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> getAllData() throws Exception{
		return new ResponseEntity<>(service.getAllData(), HttpStatus.OK);
	}

	@GetMapping(value = "/getdataid/{id}", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> getDataId(@Valid @PathVariable Integer id) throws Exception{
		return new ResponseEntity<>(service.getDataId(id), HttpStatus.OK);
	}

	@PostMapping(value = "/create", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> createData(@Valid @RequestBody Users post) throws Exception{
		return new ResponseEntity<>(service.createData(post), HttpStatus.OK);
	}

	@PutMapping(value = "/update", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> updateData(@Valid @RequestBody Users post) throws Exception{
		return new ResponseEntity<>(service.updateData(post), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteId/{id}", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> deleteId(@Valid @PathVariable Integer id) throws Exception{
		service.deleteData(id);
		return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
	}
	
	@PostMapping(path = "/createpermissions", produces = {MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> createDataPermissions(@Valid @RequestBody WoloxpermissionsApi data) throws Exception{
		return new ResponseEntity<>(permissionservice.createPermissions(data), HttpStatus.OK);
	}

	@GetMapping(value = "/getallpermissions", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> getAllDataPermissions() throws Exception{
		return new ResponseEntity<>(permissionservice.readPermissions(), HttpStatus.OK);
	}

}
