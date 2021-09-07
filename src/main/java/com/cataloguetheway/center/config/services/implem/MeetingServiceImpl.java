package com.cataloguetheway.center.config.services.implem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.Dao.MeetingDao;
import com.cataloguetheway.center.config.model.Meeting;
import com.cataloguetheway.center.config.services.MeetingInt;

@Service
public class MeetingServiceImpl  implements MeetingInt{

	@Autowired
	private MeetingDao meetingRepository;
	
	
	@Override
	public List<Meeting> getAllMeetings() {
		return meetingRepository.findAll();
	}

	@Override
	public Meeting add(Meeting m) {
		return meetingRepository.save(m);
	}

	@Override
	public Meeting getById(Long id) {
		
		Optional<Meeting> seance= meetingRepository.findById(id);
		  
		if(seance.isPresent()) {
			   return seance.get();
		   }
		return null;
	}

	@Override
	public void delete(Long id) {
		meetingRepository.deleteById(id);
		
	}

	@Override
	public Meeting update(Meeting meeting) {
		return meetingRepository.save(meeting);
	}

}
