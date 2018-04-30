package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces({MediaType.APPLICATION_JSON})
public class UsersEndpoint {

  @GET
  public Response get(){
    return Response.ok("users").build();
  }

  @POST
  public Response post(String body){
    System.out.println(body);
    return Response.status(Response.Status.CREATED).build();
  }

}
