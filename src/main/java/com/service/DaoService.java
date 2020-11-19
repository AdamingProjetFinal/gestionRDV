package com.service;

import java.util.List;

public interface DaoService<O> {
	
	O saveOrUpdate(O obj);
	void delete(Long id);
	O find (Long id);
	List<O>findAll();
	

}
