/**
 * @autor CACP - 17/05/2021
 */
package com.woloxnetwork.api;

import javax.validation.constraints.NotBlank;

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
@JsonRootName(value = "filterdatacomments")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDataCommentsApi {

	@NotBlank
    @JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "userid")
	private Integer userid;

}
