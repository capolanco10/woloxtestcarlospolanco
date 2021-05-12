/**
 * @autor CACP - RFAST9 11/05/2021
 */
package com.woloxclientapi.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woloxclientapi.dto.Posts;

/**
 * @autor luxos CACP - RFAST9 11/05/2021
 *
 */
@FeignClient(name="posts", url="https://jsonplaceholder.typicode.com")
public interface PostsService {

	
	@RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<Posts> getAll();

	//@RequestMapping(method = RequestMethod.POST, value = "/posts")
    //List<Posts> createData(@RequestBody Posts posts);

}
