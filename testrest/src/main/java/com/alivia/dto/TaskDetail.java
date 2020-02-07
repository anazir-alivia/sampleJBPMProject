package com.alivia.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "task-summary")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class TaskDetail implements Serializable {

	
	 private Integer taskId;
	 private String taskName;
	 private String taskSubject;
	 private String taskDescription;
	 private String taskStatus;
	 private String taskPriority;
	 private String taskIsSkipable;
	 private Date taskCreatedOn;
	 private Date taskActivationTime;
	 private Integer taskProcessInstanceId;
	 private String taskDefinationID;
	 private String taskContainerID;
	 private String taskParentId;

	 @XmlElement(name = "task-id") 
	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "TaskDetail [taskId=" + taskId + ", taskName=" + taskName + ", taskSubject=" + taskSubject
				+ ", taskDescription=" + taskDescription + ", taskStatus=" + taskStatus + ", taskPriority="
				+ taskPriority + ", taskIsSkipable=" + taskIsSkipable + ", taskCreatedOn=" + taskCreatedOn
				+ ", taskActivationTime=" + taskActivationTime + ", taskProcessInstanceId=" + taskProcessInstanceId
				+ ", taskDefinationID=" + taskDefinationID + ", taskContainerID=" + taskContainerID + ", taskParentId="
				+ taskParentId + "]";
	}

	@XmlElement(name = "task-name") 
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@XmlElement(name = "task-subject")
	public String getTaskSubject() {
		return taskSubject;
	}

	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}

	@XmlElement(name = "task-description")
	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@XmlElement(name = "task-status")
	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@XmlElement(name = "task-priority")
	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	@XmlElement(name = "task-is-skipable")
	public String getTaskIsSkipable() {
		return taskIsSkipable;
	}

	public void setTaskIsSkipable(String taskIsSkipable) {
		this.taskIsSkipable = taskIsSkipable;
	}

	@XmlElement(name = "task-created-on")
	public Date getTaskCreatedOn() {
		return taskCreatedOn;
	}

	public void setTaskCreatedOn(Date taskCreatedOn) {
		this.taskCreatedOn = taskCreatedOn;
	}

	@XmlElement(name = "task-activation-time")
	public Date getTaskActivationTime() {
		return taskActivationTime;
	}

	public void setTaskActivationTime(Date taskActivationTime) {
		this.taskActivationTime = taskActivationTime;
	}

	@XmlElement(name = "task-proc-inst-id")
	public Integer getTaskProcessInstanceId() {
		return taskProcessInstanceId;
	}

	public void setTaskProcessInstanceId(Integer taskProcessInstanceId) {
		this.taskProcessInstanceId = taskProcessInstanceId;
	}

	@XmlElement(name = "task-proc-def-id")
	public String getTaskDefinationID() {
		return taskDefinationID;
	}

	public void setTaskDefinationID(String taskDefinationID) {
		this.taskDefinationID = taskDefinationID;
	}

	@XmlElement(name = "task-container-id")
	public String getTaskContainerID() {
		return taskContainerID;
	}

	public void setTaskContainerID(String taskContainerID) {
		this.taskContainerID = taskContainerID;
	}

	@XmlElement(name = "task-parent-id")
	public String getTaskParentId() {
		return taskParentId;
	}

	public void setTaskParentId(String taskParentId) {
		this.taskParentId = taskParentId;
	}
	
	
}
