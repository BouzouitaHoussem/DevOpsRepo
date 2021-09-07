package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.SessionDao;
import com.cataloguetheway.center.config.model.Session;
import com.cataloguetheway.center.config.services.SessionInt;


@Service
public class SessionServiceImpl implements SessionInt {

	
	@Autowired 
	private SessionDao sessionRepository;
	
	@Override
	public List<Session> getAllSessions() {
		return sessionRepository.findAll();
	}

	@Override
	public Session add(Session s) {
		
		return  sessionRepository.save(s);
	}

	@Override
	public Session getById(Long id) {
      Optional<Session> s= sessionRepository.findById(id);
      
      if(s.isPresent()) {
    	  return s.get();
      }
      return null;
	}

	@Override
	public void delete(Long id) {
	   sessionRepository.deleteById(id);
	}

	@Override
	public Session update(Session s) {
		return  sessionRepository.save(s);
	}

}
