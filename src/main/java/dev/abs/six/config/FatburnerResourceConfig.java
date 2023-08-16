package dev.abs.six.config;

import dev.abs.six.service.UserInputServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class FatburnerResourceConfig extends ResourceConfig {

    public FatburnerResourceConfig() {
        packages("dev.abs.six.controller");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(new UserInputServiceImpl()).to(UserInputServiceImpl.class);
            }
        });
    }
}
