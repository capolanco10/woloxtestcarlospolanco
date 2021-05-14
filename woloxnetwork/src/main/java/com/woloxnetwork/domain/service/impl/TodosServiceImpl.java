/**
 * @autor CACP - 5/02/2021
 */
package com.woloxnetwork.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woloxnetwork.domain.service.Jsonplaceholder;
import com.woloxnetwork.domain.service.TodosService;
import com.woloxnetwork.dto.Todos;

/**
 * @autor luxos CACP - 5/02/2021
 *
 */
@Service
public class TodosServiceImpl implements Jsonplaceholder<Todos, Integer>{
	
	@Autowired
	private TodosService service;

	@Override
	public List<Todos> getAllData() {
		return service.getAll();
	}

	@Override
	public Todos getDataId(Integer id) {
		if(id != null) {
			return service.getId(id);
		}
		return null;
	}

	@Override
	public Todos createData(Todos data) {
		return service.createData(data);
	}

	@Override
	public Todos updateData(Todos data) {
		return service.updateData(data.getId(), data);
	}

	@Override
	public void deleteData(Integer id) {
		if(id != null) {
			service.deleteId(id);
		}
	}
	
	public List<Todos> getTodosUsersId(Integer id) {
		if(id != null) {
			return service.getTodosUsersId(id);
		}
		return null;
	}

}
