/**
 * @autor CACP - 11/02/2021
 */
package com.woloxnetwork.mapper;

import org.springframework.stereotype.Component;

import com.woloxnetwork.api.WoloxpermissionsApi;
import com.woloxnetwork.domain.model.Woloxpermissions;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * @autor luxos CACP - 11/02/2021
 *
 */
@Component
public class WoloxpermissionsMapper extends ConfigurableMapper{

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(Woloxpermissions.class, WoloxpermissionsApi.class).byDefault().register();
	}
	
}
