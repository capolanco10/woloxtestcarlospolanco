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

import com.woloxnetwork.dto.Posts;

/**
 * @autor luxos CACP - 11/05/2021
 *
 */
@FeignClient(name="posts", url="https://jsonplaceholder.typicode.com")
public interface PostsService {

	
	@RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<Posts> getAll();

	@RequestMapping(method = RequestMethod.GET, value = "/posts/{id}")
    public Posts getId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/posts")
    public Posts createData(@RequestBody Posts posts);

	@RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}")
    public Posts updateData(@PathVariable(name = "id") int id, @RequestBody Posts posts);

	@RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
    public void deleteId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}/posts")
    public void getPostsUsersId(@PathVariable(name = "id") int id);
	
}
