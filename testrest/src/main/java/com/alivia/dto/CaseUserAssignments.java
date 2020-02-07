package com.alivia.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


public class CaseUserAssignments implements Serializable {

	private String owner;

	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "CaseUserAssignments [owner=" + owner + "]";
	}
	
}
