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

import com.woloxnetwork.dto.Todos;

/**
 * @autor luxos CACP - 11/05/2021
 *
 */
@FeignClient(name="todos", url="https://jsonplaceholder.typicode.com")
public interface TodosService {

	
	@RequestMapping(method = RequestMethod.GET, value = "/todos")
    public List<Todos> getAll();

	@RequestMapping(method = RequestMethod.GET, value = "/todos/{id}")
    public Todos getId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/todos")
    public Todos createData(@RequestBody Todos todos);

	@RequestMapping(method = RequestMethod.PUT, value = "/todos/{id}")
    public Todos updateData(@PathVariable(name = "id") int id, @RequestBody Todos todos);

	@RequestMapping(method = RequestMethod.DELETE, value = "/todos/{id}")
    public void deleteId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}/todos")
    public void getTodosUsersId(@PathVariable(name = "id") int id);

}
