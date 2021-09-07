package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.Session;

public interface SessionInt {

	  List<Session> getAllSessions();
		
	    Session add(Session s);
		
	    Session getById (Long id);
		
		void delete(Long id);
		
		Session update(Session s);
}
