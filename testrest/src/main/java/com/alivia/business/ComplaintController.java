package com.alivia.business;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.alivia.dto.CaseUserAssignments;
import com.alivia.dto.Complaint;
import com.alivia.dto.CreateComplaint;

import com.alivia.dto.*;

public class ComplaintController {

	public String createJSONComplaint(CreateComplaint createComplaint) {
		String createComplaintJSON = "";
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(CreateComplaint.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// To format JSON
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Set JSON type
			jaxbMarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
			jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

			// Print JSON String to Console
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(createComplaint, sw);
			System.out.println(sw.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return createComplaintJSON;
	}

	public static TaskSummaryList getTaskSummaryList(String xmlString) {
		JAXBContext jaxbContext;
		TaskSummaryList detail = null;
		try {
			jaxbContext = JAXBContext.newInstance(TaskSummaryList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			System.out.println("xmlString " + xmlString);
			detail = (TaskSummaryList) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));

			System.out.println(detail);
			// return detail;
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			return detail;
		}

	}

	public static CreateComplaint getTestCreateComplaint() {
		CreateComplaint createComplaint = new CreateComplaint();
		Complaint complaint = new Complaint();
		complaint.setCaseType("type");
		complaint.setHotlineDetail("Kleber called to register a complaint againt Dr. Johnson for over charging");
		complaint.setTips("Over charging is a common practice in some areas");
		complaint.setEntityInvolved("provider");
		complaint.setProviderNpi("npi-12345");
		complaint.setAllegation("Provider charged for services not rendered");
		complaint.setReporterName("Robert Smith");
		CaseUserAssignments caseUserAssignment = new CaseUserAssignments();
		caseUserAssignment.setOwner("maciek");
		createComplaint.setCaseUserAssignmnet(caseUserAssignment);
		createComplaint.setComplaint(complaint);
		return createComplaint;

	}

	public static void main(String[] args) {
		CreateComplaint createComplaint = new CreateComplaint();
		Complaint complaint = new Complaint();
		complaint.setCaseType("type");
		complaint.setHotlineDetail("Kleber called to register a complaint againt Dr. Johnson for over charging");
		complaint.setTips("Over charging is a common practice in some areas");
		complaint.setEntityInvolved("provider");
		complaint.setProviderNpi("npi-12345");
		complaint.setAllegation("Provider charged for services not rendered");
		complaint.setReporterName("Robert Smith");
		CaseUserAssignments caseUserAssignment = new CaseUserAssignments();
		caseUserAssignment.setOwner("maciek");
		createComplaint.setCaseUserAssignmnet(caseUserAssignment);
		createComplaint.setComplaint(complaint);
		new ComplaintController().createJSONComplaint(createComplaint);
	}
}
