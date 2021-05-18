/**
 * @autor CACP - 17/05/2021
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
 * @autor luxos CACP - 17/05/2021
 *
 */
@JsonRootName(value = "filterdatapermissions")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDataPermissionsApi {

	@NotBlank
	@NotNull(message = "usersid required")
    @JsonProperty(value = "usersid", required = true)
	private Integer usersid;

	@NotBlank
	@NotNull(message = "albumsid required")
    @JsonProperty(value = "albumsid", required = true)
	private Integer albumsid;
	
	@NotBlank
	@NotNull(message = "readpermission required")
    @JsonProperty(value = "readpermission", required = true)
	private Boolean readpermission;
	
	@NotBlank
	@NotNull(message = "writepermission required")
    @JsonProperty(value = "writepermission", required = true)
	private Boolean writepermission;
}
