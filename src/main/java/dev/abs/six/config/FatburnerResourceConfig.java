package dev.abs.six.config;

import org.glassfish.jersey.server.ResourceConfig;

public class FatburnerResourceConfig extends ResourceConfig {

    public FatburnerResourceConfig() {
        packages("dev.abs.six.controller");
    }
}
