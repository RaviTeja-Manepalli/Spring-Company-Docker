package com.mindtree.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.company.model.Track;

public interface TrackRepository extends JpaRepository<Track,Integer> {

	//@Query(value = "SELECT * from companyspring.track where trackname=1? ",nativeQuery = true)
	public Track getTrackByTrackname(String trackname);

}
