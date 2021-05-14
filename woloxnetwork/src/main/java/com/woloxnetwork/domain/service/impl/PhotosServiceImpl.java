/**
 * @autor CACP - 5/02/2021
 */
package com.woloxnetwork.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woloxnetwork.domain.service.Jsonplaceholder;
import com.woloxnetwork.domain.service.PhotosService;
import com.woloxnetwork.dto.Photos;

/**
 * @autor luxos CACP - 5/02/2021
 *
 */
@Service
public class PhotosServiceImpl implements Jsonplaceholder<Photos, Integer>{
	
	@Autowired
	private PhotosService service;

	@Override
	public List<Photos> getAllData() {
		return service.getAll();
	}

	@Override
	public Photos getDataId(Integer id) {
		if(id != null) {
			return service.getId(id);
		}
		return null;
	}

	@Override
	public Photos createData(Photos data) {
		return service.createData(data);
	}

	@Override
	public Photos updateData(Photos data) {
		return service.updateData(data.getId(), data);
	}

	@Override
	public void deleteData(Integer id) {
		if(id != null) {
			service.deleteId(id);
		}
	}

	public List<Photos> getPhotosAlbumsId(Integer id) {
		if(id != null) {
			return service.getPhotosAlbumsId(id);
		}
		return null;
	}

}
