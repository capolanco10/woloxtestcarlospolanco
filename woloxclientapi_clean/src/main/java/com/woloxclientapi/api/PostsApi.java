/**
 * @autor CACP - RFAST9 21/12/2020
 */
package com.woloxclientapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.woloxclientapi.domain.service.PostsService;
import com.woloxclientapi.dto.Posts;

/**
 * @autor luxos CACP
 *
 */
public class PostsApi {
	
	@Autowired
	private PostsService postsService;
	
	
	public List<Posts> getAlldata() throws Exception{
		try {

			return postsService.getAll();

		} catch (Exception e) {
			throw e;
		}
	}
}
