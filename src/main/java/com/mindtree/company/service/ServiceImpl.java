package com.mindtree.company.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.company.exception.NoMindException;
import com.mindtree.company.exception.ServiceException;
import com.mindtree.company.model.Minds;
import com.mindtree.company.model.Track;
import com.mindtree.company.repository.MindsRepository;
import com.mindtree.company.repository.TrackRepository;

@Service
public class ServiceImpl {

	@Autowired
	MindsRepository mindsr;
	@Autowired
	TrackRepository trackr;

	public Minds addMinds(Minds mind, int id) throws ServiceException {
		// TODO Auto-generated method stub
		Track track = trackr.findById(id).get();
		if (track == null) {
			throw new ServiceException();
		}
		mind.setTrack(track);
		try {
			return mindsr.save(mind);
		} catch (Exception e) {
			throw new ServiceException(e);

		}
	}

	public Track addTrack(Track track) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return trackr.save(track);
		} catch (Exception e) {
			throw new ServiceException(e);

		}
	}

	public List<Minds> getAllMindsData(String trackname) {
		// TODO Auto-generated method stub
	    	List<Minds> mindList =new ArrayList<Minds>() ;
		    Track track1 = trackr.getTrackByTrackname(trackname);
            mindList = mindsr.getMindsByTrack(track1);
            
           
		return mindList;
	}

	public void deleteMindonId(int id) throws NoMindException, ServiceException {
		// TODO Auto-generated method stub
		Minds mind1 = mindsr.findById(id).get();
		if (mind1 == null) {
			throw new NoMindException();
		}
		try {
		mindsr.delete(mind1);
		}
		catch(Exception e)
		{
			throw new ServiceException(e);
		}

	}

	public Minds updateMindNumber(String number, Integer id) throws NoMindException, ServiceException {
		// TODO Auto-generated method stub
		Minds mind1 = mindsr.findById(id).get();
		if (mind1 == null) {
			throw new NoMindException();
		}
		try {
		mind1.setPhone(number);
		return mindsr.save(mind1);
		}
		catch(Exception e)
		{
			throw new ServiceException(e);
		}
	}

}
