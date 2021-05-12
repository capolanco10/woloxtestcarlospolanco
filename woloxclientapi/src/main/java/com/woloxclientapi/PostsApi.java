/**
 * @autor CACP - RFAST9 11/05/2021
 */
package com.woloxclientapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woloxclientapi.dto.Posts;
import com.woloxclientapi.service.PostsService;

/**
 * @autor luxos CACP - RFAST9 11/05/2021
 *
 */
@Service
public class PostsApi {
	
	@Autowired
	private PostsService postsService;
	
	public List<Posts> getAllPosts(){
		
		return postsService.getAll();
	}

}
