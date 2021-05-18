/**
 * @autor CACP - 11/02/2021
 */
package com.woloxnetwork.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor luxos CACP - 11/02/2021
 *
 */
@JsonRootName(value = "comments")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsApi {

	@JsonProperty(value = "postId")
	private Integer postId;
	
    @JsonProperty(value = "id")
	private Integer id;
	
    @JsonProperty(value = "name")
	private String name;
	
    @JsonProperty(value = "email")
	private String email;
	
    @JsonProperty(value = "body")
	private String body;
}
