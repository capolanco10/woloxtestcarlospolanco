/**
 * @autor CACP - 5/02/2021
 */
package com.woloxnetwork.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woloxnetwork.domain.service.AlbumsService;
import com.woloxnetwork.domain.service.Jsonplaceholder;
import com.woloxnetwork.dto.Albums;

/**
 * @autor luxos CACP - 5/02/2021
 *
 */
@Service
public class AlbumsServiceImpl implements Jsonplaceholder<Albums, Integer>{
	
	@Autowired
	private AlbumsService service;

	@Override
	public List<Albums> getAllData() {
		return service.getAll();
	}

	@Override
	public Albums getDataId(Integer id) {
		if(id != null) {
			return service.getId(id);
		}
		return null;
	}

	@Override
	public Albums createData(Albums data) {
		return service.createData(data);
	}

	@Override
	public Albums updateData(Albums data) {
		return service.updateData(data.getId(), data);
	}

	@Override
	public void deleteData(Integer id) {
		if(id != null) {
			service.deleteId(id);
		}
	}
	
	public void getAlbumsUsersId(Integer id) {
		if(id != null) {
			service.getAlbumsUsersId(id);
		}
	}

}
