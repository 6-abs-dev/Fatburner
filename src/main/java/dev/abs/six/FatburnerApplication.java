package dev.abs.six;

import dev.abs.six.config.FatburnerResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;

public class FatburnerApplication {
    public static final String BASE_URI = "http://localhost:8080/";

    public static void main(String[] args) throws IOException {

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), new FatburnerResourceConfig());
        System.out.println(String.format("Jersey app started with endpoints available at %s", BASE_URI));
        System.in.read();
        server.stop();
    }
}

