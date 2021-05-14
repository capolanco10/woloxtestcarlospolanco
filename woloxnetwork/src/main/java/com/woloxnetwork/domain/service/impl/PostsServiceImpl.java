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
	private PostsService service;

	@Override
	public List<Posts> getAllData() {
		return service.getAll();
	}

	@Override
	public Posts getDataId(Integer id) {
		if(id != null) {
			return service.getId(id);
		}
		return null;
	}

	@Override
	public Posts createData(Posts data) {
		return service.createData(data);
	}

	@Override
	public Posts updateData(Posts data) {
		return service.updateData(data.getId(), data);
	}

	@Override
	public void deleteData(Integer id) {
		if(id != null) {
			service.deleteId(id);
		}
	}
	
	public List<Posts> getPostsUsersId(Integer id) {
		if(id != null) {
			return service.getPostsUsersId(id);
		}
		return null;
	}

}
