/**
 * @autor CACP - RFAST9 13/05/2021
 */
package com.woloxnetwork.domain.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.woloxnetwork.domain.model.Woloxpermissions;

/**
 * @autor luxos CACP - RFAST9 13/05/2021
 *
 */
@Repository
public interface WoloxpermissionsService extends JpaRepository<Woloxpermissions, Integer>{
	
	@Query("select s from Woloxpermissions s where s.albumsid = ?1 and s.usersid = ?2")
	public List<Woloxpermissions> findByAlbumsidUsersid(Integer albumsid, Integer usersid);
}
