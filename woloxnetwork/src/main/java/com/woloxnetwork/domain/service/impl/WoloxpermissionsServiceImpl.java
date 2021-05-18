/**
 * @autor CACP - 13/05/2021
 */
package com.woloxnetwork.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.woloxnetwork.api.CommentsApi;
import com.woloxnetwork.api.FilterDataCommentsApi;
import com.woloxnetwork.api.FilterDataPermissionsApi;
import com.woloxnetwork.api.WoloxpermissionsApi;
import com.woloxnetwork.domain.model.ErrorObject;
import com.woloxnetwork.domain.model.Woloxpermissions;
import com.woloxnetwork.domain.service.WoloxpermissionsService;
import com.woloxnetwork.dto.Albums;
import com.woloxnetwork.dto.Comments;
import com.woloxnetwork.dto.Posts;
import com.woloxnetwork.mapper.CommentsMapper;
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
	
	@Autowired
	private CommentsServiceImpl commentsServiceImpl;
	
	@Autowired
	private PostsServiceImpl postsServiceImpl;
	
	/**
	 * method that creates or updates post permissions per user 
	 * @autor CACP - 17/05/2021
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public ErrorObject createPermissions(WoloxpermissionsApi data)throws Exception{
        try {

        	ErrorObject errorObject = new ErrorObject();
        	errorObject.setStatusCode(500);
        	
        	//valid if shared to the same owner of the album 
        	Albums albums = albumsServiceImpl.getDataId(data.getAlbumsid());
        	
        	if(albums == null || !albums.getUserId().equals(data.getUsersid())) {
        		
        		WoloxpermissionsMapper mapper = new WoloxpermissionsMapper();
        		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        		
        		Woloxpermissions woloxpermissions = mapper.map(data, Woloxpermissions.class);
        		
        		service.save(woloxpermissions);
        		
        		errorObject.setStatusCode(200);
        		errorObject.setMessage("Create successfully");
        		errorObject.setUriRequested(ow.writeValueAsString(mapper.map(woloxpermissions, WoloxpermissionsApi.class)));
        	}else {
        		errorObject.setMessage("Create Error: the user is the original owner of the album.");
        	}
        	
        	return errorObject;
        	
        }catch (Exception e){
            throw e;
        }
    }

	@Transactional(readOnly = true)
    public ErrorObject getPermissionsFilter(FilterDataPermissionsApi filter)throws Exception{
        try {

        	List<Woloxpermissions> permisionsList = service.findByAlbumsidForPermissions(filter.getAlbumsid(), filter.getReadpermission(), filter.getWritepermission());
        	
        	if(permisionsList != null && permisionsList.size() > 0) {
        		
        		if(filter.getUsersid() != null) {

        			permisionsList = permisionsList.stream()
        	                .filter(line -> line.getUsersid().equals(filter.getUsersid()))
        	                .collect(Collectors.toList());
        		}
        	}
        	
    		WoloxpermissionsMapper mapper = new WoloxpermissionsMapper();
    		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        	
        	ErrorObject errorObject = new ErrorObject();
    		errorObject.setStatusCode(200);
    		errorObject.setMessage("Data successfully");
    		errorObject.setUriRequested(ow.writeValueAsString(mapper.mapAsList(permisionsList, WoloxpermissionsApi.class)));
        	
        	return errorObject;
    		
        }catch (Exception e){
            throw e;
        }
    }

	@Transactional(readOnly = true)
    public ErrorObject getAllComments(FilterDataCommentsApi name)throws Exception{
        try {

        	List<Comments> commentsList = commentsServiceImpl.getAllData();
        	
        	if(commentsList != null && commentsList.size() > 0) {
        		
        		if(name != null && name.getName() != null) {

        			commentsList = commentsList.stream()
        	                .filter(line -> line.getName().equals(name.getName()))
        	                .collect(Collectors.toList());
        		}
        		
        		if(name != null && name.getUserid() != null) {
        			
        			List<Posts> postsList = postsServiceImpl.getPostsUsersId(name.getUserid());
        			
        			if(postsList != null && postsList.size() > 0) {
        			
        				commentsList = commentsList.stream()
        						.filter(comment -> postsList.stream()
        								.anyMatch(posts -> 
        									comment.getPostId().equals(posts.getId())))
        					    .collect(Collectors.toList());        				
        			}
        		}
        	}
        	
        	CommentsMapper mapper = new CommentsMapper();
    		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        	
        	ErrorObject errorObject = new ErrorObject();
    		errorObject.setStatusCode(200);
    		errorObject.setMessage("Comments successfully");
    		errorObject.setUriRequested(ow.writeValueAsString(mapper.mapAsList(commentsList, CommentsApi.class)));
        	
        	return errorObject;
    		
        }catch (Exception e){
            throw e;
        }
    }
	

	/**
	 * return all data permissions
	 * @autor CACP - RFAST9 17/05/2021
	 * @return
	 */
	@Transactional(readOnly = true)
    public List<WoloxpermissionsApi> readPermissions(){
    	
    	WoloxpermissionsMapper mapper = new WoloxpermissionsMapper();
    	
        return mapper.mapAsList(service.findAll(), WoloxpermissionsApi.class);
    }	
	
}
