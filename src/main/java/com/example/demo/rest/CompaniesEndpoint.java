package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/companies")
@Produces({MediaType.APPLICATION_JSON})
public class CompaniesEndpoint {

  @GET
  public Response get(){
    return Response.ok("companies").build();
  }

}
