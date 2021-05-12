/**
 * @autor CACP - 5/02/2021
 */
package com.woloxnetwork.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woloxnetwork.domain.service.Jsonplaceholder;
import com.woloxnetwork.domain.service.PostsService;
import com.woloxnetwork.dto.Posts;

/**
 * @autor luxos CACP - 5/02/2021
 *
 */
@Service
public class PostsServiceImpl implements Jsonplaceholder<Posts, Integer>{
	
	@Autowired
	private PostsService postsService;

	@Override
	public List<Posts> getAllData() {
		return postsService.getAll();
	}

	@Override
	public Posts getDataId(Integer id) {
		if(id != null) {
			return postsService.getPostId(id);
		}
		return null;
	}

	@Override
	public Posts createData(Posts data) {
		return postsService.createData(data);
	}

	@Override
	public Posts updateData(Posts data) {
		return postsService.updateData(data.getId(), data);
	}

	@Override
	public void deleteData(Integer id) {
		if(id != null) {
			postsService.deletePostId(id);
		}
	}
}
