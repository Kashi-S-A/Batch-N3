package com.tyss;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int eid;
	private double cc;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public double getCc() {
		return cc;
	}

	public void setCc(double cc) {
		this.cc = cc;
	}

}
