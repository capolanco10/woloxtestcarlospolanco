/**
 * @autor CACP - RFAST9 17/05/2021
 */
package com.woloxnetwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woloxnetwork.api.FilterDataPermissionsApi;
import com.woloxnetwork.api.WoloxpermissionsApi;
import com.woloxnetwork.domain.model.ErrorObject;
import com.woloxnetwork.domain.service.impl.WoloxpermissionsServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @autor luxos CACP - RFAST9 17/05/2021
 *
 */
@RestController
@RequestMapping(path = "/api/v1/woloxpostscontroller")
@Validated
@CrossOrigin(origins = "*")
public class WoloxPostsController {

	@Autowired
	private WoloxpermissionsServiceImpl permissionservice;  

	@ApiOperation(value = "Create Permissions for albums", response = ErrorObject.class)
	@PostMapping(path = "/createpermissions", produces = {MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> createDataPermissions(@Valid @RequestBody WoloxpermissionsApi data) throws Exception{
		return new ResponseEntity<>(permissionservice.createPermissions(data), HttpStatus.OK);
	}

	@ApiOperation(value = "Update Permissions for albums", response = ErrorObject.class)
	@PutMapping(path = "/createpermissions", produces = {MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> updateDataPermissions(@Valid @RequestBody WoloxpermissionsApi data) throws Exception{
		return new ResponseEntity<>(permissionservice.createPermissions(data), HttpStatus.OK);
	}

	@ApiOperation(value = "get all permissions", response = ErrorObject.class)
	@GetMapping(value = "/getallpermissions", headers="Accept=application/json")
	public @ResponseBody ResponseEntity<?> getAllDataPermissions() throws Exception{
		return new ResponseEntity<>(permissionservice.readPermissions(), HttpStatus.OK);
	}

	@ApiOperation(value = "get permissions for album id and permissions", response = ErrorObject.class)
	@GetMapping(value = "/getuserpermissions", produces = {MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getUserPermissions(@Valid @RequestBody FilterDataPermissionsApi data) throws Exception{
		return new ResponseEntity<>(permissionservice.getPermissionsFilter(data), HttpStatus.OK);
	}

}
