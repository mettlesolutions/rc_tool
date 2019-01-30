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
    public Response uploadFile(@MultipartForm FileUploadForm form) {
  
        String fileName = form.getFileName();
        System.out.println(fileName);
        String completeFilePath = "C:/Users/sivaabhishek/eclipse-workspace/RCC/" + fileName;
        try
        {
            //Save the file
            File file = new File(completeFilePath);
              
            if (!file.exists())
            {
                file.createNewFile();
            }
      
            FileOutputStream fos = new FileOutputStream(file);
      
            fos.write(form.getFileData());
            fos.flush();
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //Pass the POJO to the stand-alone application and run it
        RCClientProcessor rc = new RCClientProcessor();
        rc.rcProcessor(form);
        
        //Build a response to return
        String json = "{ \"name\":\"" + form.getFirstName() +" "+ form.getLastName() + "\", \"caseid\":\"" + form.getCaseID() + "\", \"claimID\":\"" + form.getClaimID() + "\", \"subscriberid\":\"" + form.getSubscriberID() + "\", \"letterid\":\"" + form.getLetterID() + "\", \"file-status\":\"uploaded\"}";
  	  return Response.ok(json, "application/json").build();
    }
}  