/**
 * @autor CACP -  11/05/2021
 */
package com.woloxnetwork.dto;

import lombok.Data;

/**
 * @autor luxos CACP - 11/05/2021
 *
 */
@Data
public class Comments {
	
	private Integer postId;
	private Integer id;
	private String name;
	private String email;
	private String body;
	
}
