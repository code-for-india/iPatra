package com.ipatra.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ipatra.IndentResponse;
import com.ipatra.Route;
import com.ipatra.School;
import com.ipatra.Track;
import com.ipatra.dataaccess.DataAccess;

@Path("/ipatra")
public class JSONService {

	DataAccess dataAccess = new DataAccess();
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {
			
		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();

	}

	@GET
	@Path("/getRouteList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Route> getRouteList() {
		List<Route> rList = new ArrayList<Route>();
		rList = dataAccess.getRouteList();
		return rList;

	}


	@GET
	@Path("/getSchoolsOnRoute")
	@Produces(MediaType.APPLICATION_JSON)
	public List<School> getSchoolsOnRoute(@QueryParam("routeId") int routeId) {
		List<School> schools = new ArrayList<School>();
		schools = dataAccess.getSchoolsOnRoute(routeId);
		return schools;

	}
	

	@GET
	@Path("/getIndent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<IndentResponse> getIndent(@QueryParam("sid") int sid,
			@QueryParam("forDate") Calendar date) {
		List<IndentResponse> responses = new ArrayList<IndentResponse>();
		responses = dataAccess.getIndent(sid,date);
		return responses;

	}
	
	@GET
	@Path("/updateIndent")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean getIndent(@QueryParam("sid") int sid,
			@QueryParam("forDate") Calendar date,@QueryParam("previousDayQty") int previousDayQty,
			@QueryParam("requestedQty") int requestedQty) {
		dataAccess.updateIndent(sid,date,previousDayQty,requestedQty);
		return true;

	}
	

}