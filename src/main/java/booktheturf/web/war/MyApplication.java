package booktheturf.web.war;

import org.glassfish.jersey.server.ResourceConfig;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        packages("booktheturf.web.war");
        register(JacksonJsonProvider.class);
    }
}