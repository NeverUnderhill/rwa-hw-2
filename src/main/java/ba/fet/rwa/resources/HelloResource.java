package ba.fet.rwa.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response hello() {
		String output = "hello world!";
		return Response.status(200).entity(output).build();
	}
}
