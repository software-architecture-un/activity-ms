package sa.activity.resource;

import sa.activity.model.Activity;
import sa.activity.service.ActivityService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.persistence.Entity;
import java.net.URI;
import java.util.List;

@Path("/activities")
public class ActivityResource {

    ResponseBuilder response;

    @Context
    UriInfo uriInfo;

    @EJB
    ActivityService activityService;

    @GET
    public List<Activity> getAllActivitys(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return activityService.getAllActivitys(first, maxResult);
    }

    @GET
    @Path("{id}")
    public Response getActivityByCode(@PathParam("id") long code) {
        Activity activity = activityService.getActivityByCode(code);
        response = Response.status(Response.Status.OK);
        response.entity(activity);
        return response.build();
    }

    @POST
    public Response createActivity(Activity activity) {
        Activity createdActivity = activityService.createActivity(activity);
        response = Response.status(Response.Status.CREATED);
        response.entity(createdActivity);
        return response.build();
    }

    @PUT
    @Path("{id}")
    public Response updateActivity(@PathParam("id") long code, Activity activity) {
        Activity updatedActivity = activityService.updateActivity(code, activity);
        response = Response.status(Response.Status.OK);
        response.entity(updatedActivity);
        return response.build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteActivity(@PathParam("id") long code) {
        long deletedActivityCode = activityService.deleteActivity(code);
        response = Response.status(Response.Status.OK);
        response.entity(deletedActivityCode);
        return response.build();
    }

}
