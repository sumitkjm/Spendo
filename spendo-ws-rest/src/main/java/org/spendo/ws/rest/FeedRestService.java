package org.spendo.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.spendo.reportws.vo.json.SPFeedOutput;
import org.spendo.reportws.vo.json.SPWSFeedInput;
import org.spendo.reportws.vo.json.SPWSFeedOutput;

@Path("/feed-rest-service")
public class FeedRestService {
	
	@POST
    @Produces("application/json")
	@Consumes("application/json")
	@Path("/persist-feed")
	public Response persistFeed(SPWSFeedInput spwsFeedInput) {
		return Response.ok().entity(createDummyFeed()).build();
	}
	
	private SPWSFeedOutput createDummyFeed() {
		SPWSFeedOutput spwsFeedOutput = new SPWSFeedOutput();
		SPFeedOutput spFeedOutput = new SPFeedOutput();
		spFeedOutput.setUserID("sumitk");
		spwsFeedOutput.setSPFeedOutput(spFeedOutput);
		return spwsFeedOutput;
	}

}
