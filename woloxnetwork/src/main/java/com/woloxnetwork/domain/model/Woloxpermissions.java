/**
 * @autor CACP - RFAST9 13/05/2021
 */
package com.woloxnetwork.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor luxos CACP - RFAST9 13/05/2021
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "woloxpermissions",  
		indexes = {@Index(name = "uq_1", columnList = "albumsid,usersid", unique = true)})
public class Woloxpermissions {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private Integer albumsid;
	
	@Column(nullable = false)
	private Integer usersid;
	
	@Column(nullable = false)
	private Boolean readpermission;
	
	@Column(nullable = false)
	private Boolean writepermission;
}
