/**
 * @autor CACP - RFAST9 18/05/2021
 */
package com.woloxnetwork.domain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.woloxnetwork.api.WoloxpermissionsApi;
import com.woloxnetwork.domain.model.ErrorObject;
import com.woloxnetwork.domain.model.Woloxpermissions;
import com.woloxnetwork.domain.service.WoloxpermissionsService;
import com.woloxnetwork.dto.Albums;
import com.woloxnetwork.mapper.WoloxpermissionsMapper;

/**
 * @autor luxos CACP - RFAST9 18/05/2021
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class WoloxpermissionsServiceImplTest {
	
	@InjectMocks
	private WoloxpermissionsServiceImpl woloxpermissionsServiceImpl;
	
	@Mock
	private AlbumsServiceImpl albumsServiceImpl;
	
	@Mock
	private WoloxpermissionsApi woloxpermissionsApi;
	
	@Mock
	private WoloxpermissionsService service;
	
	private WoloxpermissionsMapper mapper = new WoloxpermissionsMapper();
	
	@Mock
	private WoloxpermissionsMapper mapperMock;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createPermissionsOwner() {
		
		woloxpermissionsApi = new WoloxpermissionsApi();
		woloxpermissionsApi.setAlbumsid(1);
		woloxpermissionsApi.setUsersid(2);
		
		Mockito.when( albumsServiceImpl.getDataId(woloxpermissionsApi.getAlbumsid()) ).thenReturn(consultaAlbumsServiceImplgetDataId(1,2));
		ErrorObject errorObject  = null;
		try {
			 errorObject  = woloxpermissionsServiceImpl.createPermissions(woloxpermissionsApi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(errorObject.getStatusCode(), 500);
	}

	@Test
	public void createPermissionsNotOwner() {
		
		woloxpermissionsApi = new WoloxpermissionsApi();
		woloxpermissionsApi.setAlbumsid(1);
		woloxpermissionsApi.setUsersid(2);
		
		Woloxpermissions data = mapper.map(woloxpermissionsApi, Woloxpermissions.class);
		
		Mockito.when( albumsServiceImpl.getDataId(woloxpermissionsApi.getAlbumsid()) ).thenReturn(null);
		
		Mockito.when( service.save(data) ).thenReturn(null);
		
		ErrorObject errorObject  = null;
		try {
			 errorObject  = woloxpermissionsServiceImpl.createPermissions(woloxpermissionsApi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(errorObject.getStatusCode(), 200);
	}

	@Test
	public void createPermissionsNotOwnerId() {
		
		woloxpermissionsApi = new WoloxpermissionsApi();
		woloxpermissionsApi.setAlbumsid(1);
		woloxpermissionsApi.setUsersid(2);
		
		Woloxpermissions data = mapper.map(woloxpermissionsApi, Woloxpermissions.class);
		
		Mockito.when( albumsServiceImpl.getDataId(woloxpermissionsApi.getAlbumsid()) ).thenReturn(consultaAlbumsServiceImplgetDataId(2, 1));
		
		Mockito.when( service.save(data) ).thenReturn(null);
		
		ErrorObject errorObject  = null;
		try {
			 errorObject  = woloxpermissionsServiceImpl.createPermissions(woloxpermissionsApi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(errorObject.getStatusCode(), 200);
	}
	
	@Test (expected = Exception.class)
    public void createPermissionsByIdNull() throws Exception {
		woloxpermissionsApi = new WoloxpermissionsApi();
		woloxpermissionsApi.setAlbumsid(1);
		woloxpermissionsApi.setUsersid(2);
		
		Woloxpermissions data = mapper.map(woloxpermissionsApi, Woloxpermissions.class);
		
		Mockito.when( albumsServiceImpl.getDataId(woloxpermissionsApi.getAlbumsid()) ).thenReturn(consultaAlbumsServiceImplgetDataId(2, 1));
		
		Mockito.when( service.save(data) ).thenThrow(new NullPointerException("preuba"));
		
		woloxpermissionsServiceImpl.createPermissions(woloxpermissionsApi);
		
    }
	
	
	public Albums consultaAlbumsServiceImplgetDataId(Integer id, Integer userid) {
		Albums albums = new Albums();
		albums.setId(id);
		albums.setTitle("text");
		albums.setUserId(userid);
		return albums;
	}
	

}
