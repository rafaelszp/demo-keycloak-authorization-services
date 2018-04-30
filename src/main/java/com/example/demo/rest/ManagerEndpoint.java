package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/manager")
@Produces({MediaType.APPLICATION_JSON})
public class ManagerEndpoint {

  @GET
  public Response get(){
    return Response.ok("manager").build();
  }

}
