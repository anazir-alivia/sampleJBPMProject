package com.alivia.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class CreateComplaint implements Serializable {

	private Complaint complaint;
	private CaseUserAssignments caseUserAssignmnet;
	@XmlElement(name = "case-data")
	public Complaint getComplaint() {
		return complaint;
	}
	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}
	@XmlElement(name = "case-user-assignments")
	public CaseUserAssignments getCaseUserAssignmnet() {
		return caseUserAssignmnet;
	}
	public void setCaseUserAssignmnet(CaseUserAssignments caseUserAssignmnet) {
		this.caseUserAssignmnet = caseUserAssignmnet;
	}
	@Override
	public String toString() {
		return "CreateComplaint [complaint=" + complaint + ", caseUserAssignmnet=" + caseUserAssignmnet + "]";
	}
	
}
