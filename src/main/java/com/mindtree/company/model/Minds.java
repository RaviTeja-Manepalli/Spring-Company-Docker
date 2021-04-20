package com.mindtree.company.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Minds {
	@Id
	private int id;
	private String mindname;
	private String role;
	private String phone;
	@OneToOne
	private Track track;
	public Minds() {
		super();
	}
	public Minds(int id, String mindname, String role, String phone, Track track) {
		super();
		this.id = id;
		this.mindname = mindname;
		this.role = role;
		this.phone = phone;
		this.track = track;
	}
	
	public Minds(String phone) {
		super();
		this.phone = phone;
	}
	public String getMindname() {
		return mindname;
	}
	public void setMindname(String mindname) {
		this.mindname = mindname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Track getTrack() {
		return track;
	}
	public void setTrack(Track track) {
		this.track = track;
	}
	

}
