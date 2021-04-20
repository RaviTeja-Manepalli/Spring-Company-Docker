package com.mindtree.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.company.model.Minds;
import com.mindtree.company.model.Track;

public interface MindsRepository extends JpaRepository<Minds,Integer> {
	public List<Minds> getMindsByTrack(Track track);
	
}
