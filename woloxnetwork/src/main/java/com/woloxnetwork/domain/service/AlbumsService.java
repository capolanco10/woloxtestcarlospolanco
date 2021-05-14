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

import com.woloxnetwork.dto.Albums;

/**
 * @autor luxos CACP - 11/05/2021
 *
 */
@FeignClient(name="albums", url="https://jsonplaceholder.typicode.com")
public interface AlbumsService {

	
	@RequestMapping(method = RequestMethod.GET, value = "/albums")
    public List<Albums> getAll();

	@RequestMapping(method = RequestMethod.GET, value = "/albums/{id}")
    public Albums getId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/albums")
    public Albums createData(@RequestBody Albums albums);

	@RequestMapping(method = RequestMethod.PUT, value = "/albums/{id}")
    public Albums updateData(@PathVariable(name = "id") int id, @RequestBody Albums albums);

	@RequestMapping(method = RequestMethod.DELETE, value = "/albums/{id}")
    public void deleteId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}/albums")
    public List<Albums> getAlbumsUsersId(@PathVariable(name = "id") int id);

}
