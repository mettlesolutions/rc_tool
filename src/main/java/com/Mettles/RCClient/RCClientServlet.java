package com.Mettles.RCClient;

import java.util.Date;
import java.util.Random;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
 
@Path("/")
public class RCClientServlet 
{	
	
	
	
	@Path("/test")
	@GET
	@Produces("text/html")
	public Response getStartingPage()
	{
		String output = "<h1>Hello World!<h1>" +
				"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br> Running the standalone.";
		RCClientProcessor RC = new RCClientProcessor();
		RC.RCProcessor();
		return Response.status(200).entity(output).build();
		
	}
	
	@Path("/post")
	@POST
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getMsg(String jsonObject) throws Exception
	{
		Gson g = new Gson();
		RCFormData rcdata = g.fromJson(jsonObject, RCFormData.class);
	  if ((rcdata.getEmail() == null) || (rcdata.getName() == null)) {
	      return Response.serverError().entity("Fields cannot be blank").build();
	  }
	  Random rand = new Random();
	  String json = "{ \"email\":\"" + rcdata.getEmail() + "\", \"name\":\"" + rcdata.getName() + "\", \"id\":\"" + rand.nextInt(999) + "\"}";
	  return Response.ok(json, "application/json").build();
	}
}