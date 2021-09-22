package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        InputStream is = GreetingResource.class.getResourceAsStream("/application.properties");
        Properties properties = new Properties();
        properties.load(is);

        return properties.getProperty("buildTimeStamp");
    }
}