package org.spendo.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.spendo.commons.vo.json.SpFeedOutput;
import org.spendo.commons.vo.json.SPWSFeedInput;
import org.spendo.commons.vo.json.SPWSFeedOutput;

@Path("/feed-rest-service")
public class FeedRestService {
	
	@POST
    @Produces("application/json")
	@Consumes("application/json")
	@Path("/persist-feed")
	public Response persistFeed(SPWSFeedInput spwsFeedInput) {
		spwsFeedInput.getSpFeedInput()
		return Response.ok().entity(createDummyFeed()).build();
	}
	
	private SPWSFeedOutput createDummyFeed() {
		SPWSFeedOutput spwsFeedOutput = new SPWSFeedOutput();
		SpFeedOutput spFeedOutput = new SpFeedOutput();
		spFeedOutput.setUserID("sumitk");
		spwsFeedOutput.setSpFeedOutput(spFeedOutput);
		return spwsFeedOutput;
	}

}
