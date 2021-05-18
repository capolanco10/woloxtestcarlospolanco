/**
 * @autor CACP - 11/02/2021
 */
package com.woloxnetwork.mapper;

import org.springframework.stereotype.Component;

import com.woloxnetwork.api.FilterDataCommentsApi;
import com.woloxnetwork.dto.Comments;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * @autor luxos CACP - 11/02/2021
 *
 */
@Component
public class CommentsMapper extends ConfigurableMapper{

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(Comments.class, FilterDataCommentsApi.class).byDefault().register();
	}
	
}
