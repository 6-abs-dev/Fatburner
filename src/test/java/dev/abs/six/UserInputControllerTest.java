package dev.abs.six;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static dev.abs.six.FatburnerApplication.BASE_URI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputControllerTest {

    private HttpServer server;
    private WebTarget target;

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in dev.six.abs package
        final ResourceConfig rc = new ResourceConfig().packages("dev.abs.six.controller");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    @BeforeEach
    public void setUp() throws Exception {
        // start the server
        server = startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(BASE_URI);
    }

    @AfterEach
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("fatburner").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
}
