package org.beacon.rest.v1;


import org.beacon.Database.MyTvShows;
import org.beacon.DispatchService.Dispacher;
import org.beacon.torrentfinder.DummyTorrentFinder;
import org.beacon.torrentfinder.Torrent;
import org.beacon.tvdb.TVDBapi;
import org.beacon.tvdb.gen.searchSeries.SeriesList;
import org.beacon.tvshow.TVShowTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1")
public class BeaconEndpoints {


    final static Logger logger = LoggerFactory.getLogger(BeaconEndpoints.class);

    @GET
    @Path("/searchtvshow")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchtvshow(@QueryParam("tvshow") String name) {
        TVDBapi api = new TVDBapi();

        return Response.ok().entity(api.searchTVShows(name)).build();
    }

    @POST
    @Path("/addtvshow")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addtvshow(TVShowTemplate tvShow) {
        Dispacher.addTVShow(tvShow);
    }

    @GET
    @Path("/getmytvshows")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getmytvshows() {
        return Response.ok().entity(MyTvShows.getTVShows()).build();
    }

    @POST
    @Path("/downloadepisode")
    @Consumes({MediaType.APPLICATION_JSON})
    public void downloadEpisode(Torrent torrent) {
        Dispacher.downloadEpisode(torrent);
    }


    @GET
    @Path("/searchtorrents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSearchTorrents(@QueryParam("query") String query) {
        return Response.ok().entity(new DummyTorrentFinder().searchTorrents(query)).build();
    }


}
