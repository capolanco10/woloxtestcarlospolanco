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

import com.woloxnetwork.dto.Comments;

/**
 * @autor luxos CACP - 11/05/2021
 *
 */
@FeignClient(name="comments", url="https://jsonplaceholder.typicode.com")
public interface CommentsService {

	
	@RequestMapping(method = RequestMethod.GET, value = "/comments")
    public List<Comments> getAll();

	@RequestMapping(method = RequestMethod.GET, value = "/comments/{id}")
    public Comments getId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/comments")
    public Comments createData(@RequestBody Comments comments);

	@RequestMapping(method = RequestMethod.PUT, value = "/comments/{id}")
    public Comments updateData(@PathVariable(name = "id") int id, @RequestBody Comments comments);

	@RequestMapping(method = RequestMethod.DELETE, value = "/comments/{id}")
    public void deleteId(@PathVariable(name = "id") int id);

	@RequestMapping(method = RequestMethod.GET, value = "/posts/{id}/comments")
    public void getCommentsPostsId(@PathVariable(name = "id") int id);

}
