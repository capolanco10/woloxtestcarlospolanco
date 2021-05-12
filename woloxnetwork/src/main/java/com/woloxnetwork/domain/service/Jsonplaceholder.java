/**
 * @autor CACP - RFAST9 12/05/2021
 */
package com.woloxnetwork.domain.service;

import java.util.List;

/**
 * @autor luxos CACP - 12/05/2021
 *
 */
public interface Jsonplaceholder<T, PK> {
	
	public List<T> getAllData();
	
	public T getDataId(PK id);
	
	public T createData(T data);
	
	public T updateData(T data);
	
	public void deleteData(PK id);
}
