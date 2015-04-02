package org.beacon.Rest;

import org.beacon.Database.MyTvShows;
import org.beacon.DispatchService.Dispacher;
import org.beacon.tvdbapi.TVDBapi;
import org.beacon.tvdbapi.TVShowTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

@Path("v1")
public class EntryPoint{

    final static Logger logger = LoggerFactory.getLogger(EntryPoint.class);

    @GET
    @Path("/searchtvshow")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchtvshow(@QueryParam("tvshow") String name) {
        TVDBapi api = new TVDBapi();

        return Response.ok().entity(api.searchTVShows(name)).build();
    }

    @POST
    @Path("/addtvshow")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addtvshow(TVShowTemplate tvShow) {

        Dispacher.addTVShow(tvShow);
    }

    @GET
    @Path("/getmytvshows")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getmytvshows() {
        return Response.ok().entity(MyTvShows.getTVShows()).build();
    }




}
