/**
 * @autor CACP - 11/05/2021
 */
package com.woloxnetwork.domain.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woloxnetwork.dto.Photos;

/**
 * @autor luxos CACP - 11/05/2021
 *
 */
@FeignClient(name="photos", url="https://jsonplaceholder.typicode.com")
public interface PhotosService {

	
	@RequestMapping(method = RequestMethod.GET, value = "/photos")
    public List<Photos> getAll();

	@RequestMapping(method = RequestMethod.GET, value = "/photos/{id}")
    public Photos getId(@PathVariable(name = "id") int id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/photos")
    public Photos createData(@RequestBody Photos photos);

	@RequestMapping(method = RequestMethod.PUT, value = "/photos/{id}")
    public Photos updateData(@PathVariable(name = "id") int id, @RequestBody Photos photos);

	@RequestMapping(method = RequestMethod.DELETE, value = "/photos/{id}")
    public void deleteId(@PathVariable(name = "id") int id);

	@RequestMapping(method = RequestMethod.GET, value = "/albums/{id}/photos")
    public List<Photos> getPhotosAlbumsId(@PathVariable(name = "id") int id);

}
