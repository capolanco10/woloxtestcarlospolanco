/**
 * @autor CACP - RFAST9 11/05/2021
 */
package com.woloxnetwork.domain.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woloxnetwork.dto.Users;

/**
 * @autor luxos CACP - 11/05/2021
 *
 */
@FeignClient(name="users", url="https://jsonplaceholder.typicode.com")
public interface UsersService {

	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<Users> getAll();

	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public Users getId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
    public Users createData(@RequestBody Users users);

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public Users updateData(@PathVariable(name = "id") int id, @RequestBody Users users);

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteId(@PathVariable(name = "id") int id);
}
