package com.mindtree.company.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
	@Id
	private int id;
	private String trackname;
	private int noofMinds;
   //private List<Minds>mind;
	public Track() {
		super();
	}

	public Track(int id, String trackname, int noofMinds) {
		super();
		this.id = id;
		this.trackname = trackname;
		this.noofMinds = noofMinds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrackname() {
		return trackname;
	}

	public void setTrackname(String trackname) {
		this.trackname = trackname;
	}

	public int getNoofMinds() {
		return noofMinds;
	}

	public void setNoofMinds(int noofMinds) {
		this.noofMinds = noofMinds;
	}

}
