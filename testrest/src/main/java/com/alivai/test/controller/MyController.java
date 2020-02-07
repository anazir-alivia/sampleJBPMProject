/**
* @author Ghulam Murtaza\n* @datedSat Aug 17 20:26:03 PKT 2019\n*59da4b8819a79fc7609f75a77dd7b0d5\n*/

package com.alivai.test.controller;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alivai.test.CallRestService;
import com.alivia.business.ComplaintController;
import com.alivia.dto.CaseUserAssignments;
import com.alivia.dto.Complaint;
import com.alivia.dto.CreateComplaint;
import com.alivia.dto.TaskSummaryList;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@RestController
public class MyController 
{
	@RequestMapping("/test")
	public String getData()
	{
	
		 
		System.out.println("Test the Service");
		String url = "http://localhost:8080/kie-server/services/rest/server/containers/testproject_1.0.0/forms/tasks/173/content?renderer=custom";
		//System.out.println(new com.restclient.restservice.CallRestService().sendGetRequest(url));
		return new CallRestService().sendGetRequest(url);
	}
	
	@RequestMapping("/helloOrgin")
	public String getHelloOrgin()
	{
	
		 
		System.out.println("Test the Service");
		String url = "http://localhost:8080/kie-server/services/rest/server/containers/testproject_1.0.0/forms/tasks/173/content?renderer=custom";
		//System.out.println(new com.restclient.restservice.CallRestService().sendGetRequest(url));
		return "Hello Origin 1";
	}
	
	
	@PostMapping("/CreateComplaint")
	public Complaint createComplaint(@Valid @RequestBody Complaint complaint) {
		String url = "http://192.168.0.101:8080/kie-server/services/rest/server/containers/testproject_1.0.0/cases/com.alivia.casemanagement.case/instances";
		ComplaintController complaintController = new ComplaintController();
		CreateComplaint createComplaint = new CreateComplaint();
		CaseUserAssignments caseUserAssignment = new CaseUserAssignments();
		caseUserAssignment.setOwner("maciek");
		createComplaint.setCaseUserAssignmnet(caseUserAssignment);
		createComplaint.setComplaint(complaint);
		String JSON_STRING = complaintController.createJSONComplaint(createComplaint);
		String response = new CallRestService().sendPostRequest(url, JSON_STRING);
		if (response != null) {
			response = response.substring(1, response.length() - 1);
			complaint.setCaseInstanceID(response);
		}
		System.out.println("Create Instance Response :" + complaint);
		return complaint;
	}
	
	@RequestMapping(value="GetCaseTasks", method = RequestMethod.GET)
	public @ResponseBody TaskSummaryList getComplaintTasks(@RequestParam(name = "caseInstanceID") String caseInstanceID) {
		String url = "http://192.168.0.101:8080/kie-server/services/rest/server/queries/cases/instances/" + caseInstanceID + "/tasks/instances/pot-owners?page=0&pageSize=10&";
		String response = new CallRestService().sendGetRequest(url);
		ComplaintController complaintController = new ComplaintController();
		TaskSummaryList  taskSummaryList =  complaintController.getTaskSummaryList(response);
		System.out.println("GetComplaintTasks Response :" + taskSummaryList);
		return taskSummaryList;
	}
	
	@RequestMapping(value="GetTaskFormContect", method = RequestMethod.GET)
	//@GetMapping("/GetTaskFormContect")
	
	public @ResponseBody String getTaskFormContect(@RequestParam(name = "taskId") String taskId) {
		String response = "";
		if (taskId != null) {
			String url = "http://192.168.0.101:8080/kie-server/services/rest/server/containers/testproject_1.0.0/forms/tasks/" + taskId + "/content";
			response = new CallRestService().sendGetRequest(url);			
			
		}
		
		System.out.println("Create GetTaskFormContect Instance Response :" + response);
		return response;
	}

}
/**
* @author Ghulam Murtaza
* @dated Sat Aug 17 20:07:07 PKT 2019
* 8e921a8d91963ac104a6633d30191e98
* 
*/
