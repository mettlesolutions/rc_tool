package com.MettleSol;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
 
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
 
@Path("/")
public class RCAppServer
{
    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    public Response uploadFile(@MultipartForm FileUploadForm form) throws IOException {
  
        String fileName = form.getFileName()+"."+form.getFileType();
        //System.out.println(fileName);
        String filePath = "C:/Users/sivaabhishek/eclipse-workspace/RCC/" + fileName;
        
        //Save the file on server
        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(form.getFileData());
        fos.flush();
        fos.close();
        System.out.println("File saved on the Server. Filename: "+fileName);
        
        //Pass the POJO to the stand-alone application and run it
        RCClientProcessor rc = new RCClientProcessor();
        rc.rcProcessor(form);
        
       
		//Build a response to return
        String json = "{ \"name\":\"" + form.getFirstName() 
        +" "+ form.getLastName() + "\", \"caseid\":\"" + form.getCaseID() 
        + "\", \"claimID\":\"" + form.getClaimID() + "\", \"subscriberid\":\"" 
        + form.getSubscriberID() + "\", \"letterid\":\"" + form.getLetterID() 
        +  "\", \"fileName\":\"" + fileName 
        + "\", \"file-status\":\"uploaded\"}";
        
        //Delete the file from server after upload
        file.delete();
        System.out.println("File deleted from the Server.");
		
  	  return Response.ok(json, "application/json").build();
    }
}  