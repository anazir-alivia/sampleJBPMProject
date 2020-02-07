package com.alivai.test;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alivia.business.ComplaintController;
import com.alivia.dto.CreateComplaint;
public class CallRestService {
	
	

	public String getRestCallResponse() {
		 DefaultHttpClient httpClient = new DefaultHttpClient();
		    try
		    {
		        //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
		        //Choice depends on type of method you will be invoking.
		        HttpGet getRequest = new HttpGet("http://localhost:8088/test");
		         
		        //Set the API media type in http accept header
		        getRequest.addHeader("accept", "application/text");
		          
		        //Send the request; It will immediately return the response in HttpResponse object
		        HttpResponse response = null;
				try {
					response = httpClient.execute(getRequest);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		         
		        //verify the valid error code first
		        int statusCode = response.getStatusLine().getStatusCode();
		        if (statusCode != 200) 
		        {
		            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
		        }
		         
		        //Now pull back the response object
		        HttpEntity httpEntity = response.getEntity();
		        String apiOutput = null;
				try {
					
					apiOutput = EntityUtils.toString(httpEntity);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		        //Lets see what we got from API
		        return apiOutput; //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>
		         
		    
		    }
		    finally
		    {
		        //Important: Close the connect
		        httpClient.getConnectionManager().shutdown();
		        
		    }
		
	}
	public String sendPostRequest(String url,String JSON_STRING) {
		System.out.println("Method Called.");
		 DefaultHttpClient httpClient = new DefaultHttpClient();
		    try
		    {
		        //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
		        //Choice depends on type of method you will be invoking.
		    //	System.out.println("Case ID." + caseID);
		    //	String url = "http://localhost:8080/kie-server/services/rest/server/containers/testproject_1.0.0/cases/instances/" + caseID + "/caseFile";
		    	System.out.println(url);
		        HttpPost postRequest = new HttpPost(url);
//		        String JSON_STRING = "{\r\n" + 
//		        		"    \"age\": 29,\r\n" + 
//		        		"    \"person\": {\r\n" + 
//		        		"        \"Person\": {\r\n" + 
//		        		"            \"name\": \"john4\"\r\n" + 
//		        		"        }\r\n" + 
//		        		"    }\r\n" + 
//		        		"}";

 
		        //Set the API media type in http accept header
		        postRequest.addHeader("Content-Type", "application/json");
		        postRequest.addHeader("Authorization", "Basic bWFjaWVrOm1hY2llaw==");
		          
		        //Send the request; It will immediately return the response in HttpResponse object
		        HttpResponse response = null;
				try {
					if (JSON_STRING != null && JSON_STRING.length() > 0) {
				        StringEntity requestEntity = new StringEntity(
				        	    JSON_STRING,
				        	    ContentType.APPLICATION_JSON);
	
						postRequest.setEntity(requestEntity);
					}
					response = httpClient.execute(postRequest);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		         
		        //verify the valid error code first
		        int statusCode = response.getStatusLine().getStatusCode();
		        if (statusCode != 201) 
		        {
		            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
		        }
		         
		        //Now pull back the response object
		        HttpEntity httpEntity = response.getEntity();
		        String apiOutput = null;
				try {
					
					apiOutput = EntityUtils.toString(httpEntity);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		        //Lets see what we got from API
		        return apiOutput; //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>
		         
		    
		    }
		    finally
		    {
		        //Important: Close the connect
		        httpClient.getConnectionManager().shutdown();
		        
		    }
		
	}
	
	
	public String sendGetRequest(String url) {
		System.out.println("Method Called.");
		 DefaultHttpClient httpClient = new DefaultHttpClient();
		    try
		    {
		        //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
		        //Choice depends on type of method you will be invoking.
		    	System.out.println("Case ID." + url);
		    	//String url = "http://localhost:8080/kie-server/services/rest/server/queries/cases/instances/" + caseID  + "/tasks/instances/pot-owners?page=0&pageSize=10&";
		    	//String url = "http://localhost:8080/kie-server/services/rest/server/queries/tasks/instances/pot-owners?page=0&pageSize=10&";
		    	System.out.println(url);
		        HttpGet getRequest = new HttpGet(url);
//		        String JSON_STRING = "{\r\n" + 
//		        		"    \"age\": 29,\r\n" + 
//		        		"    \"person\": {\r\n" + 
//		        		"        \"Person\": {\r\n" + 
//		        		"            \"name\": \"john4\"\r\n" + 
//		        		"        }\r\n" + 
//		        		"    }\r\n" + 
//		        		"}";

 
		        //Set the API media type in http accept header
		        getRequest.addHeader("Content-Type", "application/xml");
		        getRequest.addHeader("Authorization", "Basic bWFjaWVrOm1hY2llaw==");
		          
		        //Send the request; It will immediately return the response in HttpResponse object
		        HttpResponse response = null;
				try {
					//postRequest.setEntity(requestEntity);
					response = httpClient.execute(getRequest);
				} catch (ClientProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		         
		        //verify the valid error code first
		        int statusCode = response.getStatusLine().getStatusCode();
		        if (statusCode != 200) 
		        {
		            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
		        }
		         
		        //Now pull back the response object
		        HttpEntity httpEntity = response.getEntity();
		        String apiOutput = null;
				try {
					
					apiOutput = EntityUtils.toString(httpEntity);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		        //Lets see what we got from API
		        return apiOutput; //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>
		         
		    
		    }
		    finally
		    {
		        //Important: Close the connect
		        httpClient.getConnectionManager().shutdown();
		    }
		
	}
	
	public static void main(String[] args) {
		//http://localhost:8080/kie-server/services/rest/server/queries/cases/instances/alivia-0000000094/tasks/instances/pot-owners?page=0&pageSize=10&
	//	CallRestService callRestService = new CallRestService();
	//	System.out.println(new com.restclient.restservice.CallRestService().sendPostRequest("alivia-0000000022"));
		//System.out.println(new com.restclient.restservice.CallRestService().sendGetRequest("alivia-0000000088"));
	//	JAXBUtil.convertToObject(new com.restclient.restservice.CallRestService().sendGetRequest("alivia-0000000094"));
	//	String url = "http://localhost:8080/kie-server/services/rest/server/containers/testproject_1.0.0/forms/tasks/173/content";
	//	System.out.println(new com.restclient.restservice.CallRestService().sendGetRequest(url));
		String url = "http://localhost:8080/kie-server/services/rest/server/containers/testproject_1.0.0/cases/com.alivia.casemanagement.case/instances";
		ComplaintController complaintController = new ComplaintController();
		CreateComplaint createComplaint = complaintController.getTestCreateComplaint();
		String JSON_STRING = complaintController.createJSONComplaint(createComplaint);
		String response = new CallRestService().sendPostRequest(url, JSON_STRING);
		if (response != null) {
			response = response.substring(1, response.length() - 1);
		}
		System.out.println("Create Instance Response :" + response);
	}

}
