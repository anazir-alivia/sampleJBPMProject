package com.alivia.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Complaint implements Serializable{
	String hotlineDetail;
	String tips;
	String entityInvolved;
	String providerNpi;
	String allegation;
	String reporterName;
	String caseType;
	String caseInstanceID;
	TaskSummaryList taskSummaryList;
	
	@XmlElement(name = "taskSummaryList")
	public TaskSummaryList getTaskSummaryList() {
		return taskSummaryList;
	}
	public void setTaskSummaryList(TaskSummaryList taskSummaryList) {
		this.taskSummaryList = taskSummaryList;
	}
	
	
	@XmlElement(name = "hotline_detail")
	public String getHotlineDetail() {
		return hotlineDetail;
	}
	public void setHotlineDetail(String hotlineDetail) {
		this.hotlineDetail = hotlineDetail;
	}
	@XmlElement(name = "tips")
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@XmlElement(name = "entity_involved")
	public String getEntityInvolved() {
		return entityInvolved;
	}
	public void setEntityInvolved(String entityInvolved) {
		entityInvolved = entityInvolved;
	}
	@XmlElement(name = "provider_npi")
	public String getProviderNpi() {
		return providerNpi;
	}
	public void setProviderNpi(String providerNpi) {
		this.providerNpi = providerNpi;
	}
	@XmlElement(name = "allegation")
	public String getAllegation() {
		return allegation;
	}
	public void setAllegation(String allegation) {
		this.allegation = allegation;
	}
	@XmlElement(name = "reporter_name")
	public String getReporterName() {
		return reporterName;
	}
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	@XmlElement(name = "case_type")
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getCaseInstanceID() {
		return caseInstanceID;
	}
	public void setCaseInstanceID(String caseInstanceID) {
		this.caseInstanceID = caseInstanceID;
	}
	@Override
	public String toString() {
		return "Complaint [hotlineDetail=" + hotlineDetail + ", tips=" + tips + ", entityInvolved=" + entityInvolved
				+ ", providerNpi=" + providerNpi + ", allegation=" + allegation + ", reporterName=" + reporterName
				+ ", caseType=" + caseType + ", caseInstanceID=" + caseInstanceID + ", taskSummaryList="
				+ taskSummaryList + "]";
	}
	
	

}
