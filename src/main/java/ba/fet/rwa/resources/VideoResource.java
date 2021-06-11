package ba.fet.rwa.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ba.fet.rwa.service.VideoService;

@Path("video")
public class VideoResource {
	private VideoService videoService = new VideoService();
	private Gson gson = new Gson();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPage(
			@QueryParam("page") Integer page,
			@QueryParam("count") Integer count
			) {
		String json = gson.toJson(videoService.getRankedVideos(count, page));
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("vote")
	public Response vote(
			@QueryParam("upvotedId") int upvotedId,
			@QueryParam("downvotedId") int downvotedId
			) {
		videoService.upvote(upvotedId);
		videoService.downvote(downvotedId);

		String json = gson.toJson(videoService.get2DifferentRandomVideos());
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
}
