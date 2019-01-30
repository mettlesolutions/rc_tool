package com.MettleSol;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
 
public class FileUploadForm {
 
    public FileUploadForm() {
    }
 
    private byte[] fileData;
    private String fileName = "upload.pdf";
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String caseID;
    private String letterDate;
    private String responseDate;
    private String programName;
    private String hippsCode;
    private String claimID;
    private String comments;
    private String dateOfBirth;
    private String dateOfService;
    private String subscriberID;
    private String procedureCode;
    private String letterID;
    
    
    public String getFileName() {
        return fileName;
    }
    
    public byte[] getFileData() {
        return fileData;
    }
 
    @FormParam("selectedFile")
    @PartType("application/octet-stream")
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
    
	public String getFirstName() {
		return firstName;
	}
	
	@FormParam("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@FormParam("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	@FormParam("address")
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	
	@FormParam("city")
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	
	@FormParam("state")
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	@FormParam("zipCode")
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}
	
	@FormParam("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCaseID() {
		return caseID;
	}
	
	@FormParam("caseID")
	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}

	public String getLetterDate() {
		return letterDate;
	}
	
	@FormParam("letterDate")
	public void setLetterDate(String letterDate) {
		this.letterDate = letterDate;
		//setResponseDate(letterDate);
	}

	public String getResponseDate() {
		return responseDate;
	}
	
	@FormParam("letterDate")
	public void setResponseDate(String letterDate) {
		this.responseDate = letterDate;
	}

	/*private static String calculateResponseDate(String date) {
		return date;		
	}*/

	public String getProgramName() {
		return programName;
	}
	
	@FormParam("programName")
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getHippsCode() {
		return hippsCode;
	}

	@FormParam("hippsCode")
	public void setHippsCode(String hippsCode) {
		this.hippsCode = hippsCode;
	}

	public String getClaimID() {
		return claimID;
	}
	
	@FormParam("claimID")
	public void setClaimID(String claimID) {
		this.claimID = claimID;
	}

	public String getComments() {
		return comments;
	}
	
	@FormParam("comments")
	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	@FormParam("dateOfBirth")
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfService() {
		return dateOfService;
	}
	
	@FormParam("dateOfService")
	public void setDateOfService(String dateOfService) {
		this.dateOfService = dateOfService;
	}

	public String getSubscriberID() {
		return subscriberID;
	}
	
	@FormParam("subscriberID")
	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	public String getProcedureCode() {
		return procedureCode;
	}
	
	@FormParam("procedureCode")
	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}

	public String getLetterID() {
		return letterID;
	}

	@FormParam("letterID")
	public void setLetterID(String letterID) {
		this.letterID = letterID;
	}
	
}