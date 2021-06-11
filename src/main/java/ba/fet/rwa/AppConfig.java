package ba.fet.rwa;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ba.fet.rwa.resources.HelloResource;
import ba.fet.rwa.resources.VideoResource;

@ApplicationPath("rest")
public class AppConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(HelloResource.class);
		set.add(VideoResource.class);
		return set;
	}
}
