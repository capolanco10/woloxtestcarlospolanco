/**
 * @autor CACP - 13/05/2021
 */
package com.woloxnetwork.domain.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woloxnetwork.api.WoloxpermissionsApi;
import com.woloxnetwork.domain.model.Woloxpermissions;
import com.woloxnetwork.domain.service.WoloxpermissionsService;
import com.woloxnetwork.dto.Albums;
import com.woloxnetwork.mapper.WoloxpermissionsMapper;

/**
 * @autor luxos CACP - 13/05/2021
 *
 */
@Service
public class WoloxpermissionsServiceImpl {

	@Autowired
	private WoloxpermissionsService service;
	
	@Autowired
	private AlbumsServiceImpl albumsServiceImpl;
	
	@Transactional
    public WoloxpermissionsApi createPermissions(WoloxpermissionsApi data){
        try {

        	//valid if shared to the same owner of the album 
        	Albums albums = albumsServiceImpl.getDataId(data.getAlbumsid());
        	
        	if(albums == null || !albums.getUserId().equals(data.getUsersid())) {
        		
        		WoloxpermissionsMapper mapper = new WoloxpermissionsMapper();
        		
        		Woloxpermissions woloxpermissions = mapper.map(data, Woloxpermissions.class);
        		
        		return mapper.map(service.save(woloxpermissions), WoloxpermissionsApi.class);
        	}
        	
        }catch (Exception e){
            throw e;
        }
		return null;
    }

    public List<WoloxpermissionsApi> readPermissions(){
    	
    	WoloxpermissionsMapper mapper = new WoloxpermissionsMapper();
    	
        return mapper.mapAsList(service.findAll(), WoloxpermissionsApi.class);
    }	
	
}
