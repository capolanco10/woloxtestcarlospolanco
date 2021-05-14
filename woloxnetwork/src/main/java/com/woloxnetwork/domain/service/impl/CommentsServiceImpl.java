/**
 * @autor CACP - 5/02/2021
 */
package com.woloxnetwork.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woloxnetwork.domain.service.CommentsService;
import com.woloxnetwork.domain.service.Jsonplaceholder;
import com.woloxnetwork.dto.Comments;

/**
 * @autor luxos CACP - 5/02/2021
 *
 */
@Service
public class CommentsServiceImpl implements Jsonplaceholder<Comments, Integer>{
	
	@Autowired
	private CommentsService service;

	@Override
	public List<Comments> getAllData() {
		return service.getAll();
	}

	@Override
	public Comments getDataId(Integer id) {
		if(id != null) {
			return service.getId(id);
		}
		return null;
	}

	@Override
	public Comments createData(Comments data) {
		return service.createData(data);
	}

	@Override
	public Comments updateData(Comments data) {
		return service.updateData(data.getId(), data);
	}

	@Override
	public void deleteData(Integer id) {
		if(id != null) {
			service.deleteId(id);
		}
	}

	public List<Comments> getCommentsPostsId(Integer id) {
		if(id != null) {
			return service.getCommentsPostsId(id);
		}
		return null;
	}

}
