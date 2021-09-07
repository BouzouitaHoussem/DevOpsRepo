package com.cataloguetheway.center.config.services;

import java.util.List;

import com.cataloguetheway.center.config.model.Meeting;

public interface MeetingInt {

	    List<Meeting> getAllMeetings();
		
	    Meeting add(Meeting s);
		
	    Meeting getById (Long id);
		
		void delete(Long id);
		
		Meeting update(Meeting s);
}
