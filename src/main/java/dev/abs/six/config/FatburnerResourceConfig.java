package dev.abs.six.config;

import dev.abs.six.repository.UserInputRepository;
import dev.abs.six.repository.UserInputRepositoryImpl;
import dev.abs.six.service.UserInputService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class FatburnerResourceConfig extends ResourceConfig {

    public FatburnerResourceConfig() {
        packages("dev.abs.six");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(UserInputService.class).to(UserInputService.class);
                bind(UserInputRepositoryImpl.class).to(UserInputRepository.class);
            }
        });
    }
}
