/**
 * @autor CACP - 11/02/2021
 */
package com.woloxnetwork.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@JsonRootName(value = "woloxpermissions")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WoloxpermissionsApi {

	@JsonProperty(value = "id")
	private Integer id;
	
	@NotBlank
	@NotNull(message = "albumsid required")
    @JsonProperty(value = "albumsid", required = true)
	private Integer albumsid;
	
	@NotBlank
	@NotNull(message = "usersid required")
    @JsonProperty(value = "usersid", required = true)
	private Integer usersid;
	
	@NotBlank
	@NotNull(message = "readpermission required")
    @JsonProperty(value = "readpermission", required = true)
	private Boolean readpermission;
	
	@NotBlank
	@NotNull(message = "writepermission required")
    @JsonProperty(value = "writepermission", required = true)
	private Boolean writepermission;
}
