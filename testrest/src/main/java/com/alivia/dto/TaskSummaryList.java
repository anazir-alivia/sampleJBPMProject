package com.alivia.dto;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "task-summary-list")
@XmlAccessorType(XmlAccessType.PROPERTY)

public class TaskSummaryList {

	@Override
	public String toString() {
		return "TaskSummaryList [taskDetails=" + taskDetails + "]";
	}

	private List<TaskDetail> taskDetails;

	 @XmlElement(name = "task-summary")
	public List<TaskDetail> getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(List<TaskDetail> taskDetails) {
		this.taskDetails = taskDetails;
	}
	
	
	
}
