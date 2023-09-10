package dev.abs.six.config;

import dev.abs.six.config.exceptionMapping.GenericExceptionMapper;
import dev.abs.six.repository.*;
import dev.abs.six.service.ProductService;
import dev.abs.six.service.UserInputService;
import dev.abs.six.service.UserService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FatburnerResourceConfig extends ResourceConfig {

    public FatburnerResourceConfig() {

        packages("dev.abs.six");
        register(GenericExceptionMapper.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(UserInputService.class).to(UserInputService.class).in(Singleton.class);
                bind(UserService.class).to(UserService.class).in(Singleton.class);
                bind(ProductService.class).to(ProductService.class).in(Singleton.class);

                bind(UserInputRepositoryImpl.class).to(UserInputRepository.class).in(Singleton.class);
                bind(UserRepositoryImpl.class).to(UserRepository.class).in(Singleton.class);
                bind(ProductRepositoryImpl.class).to(ProductRepository.class).in(Singleton.class);

                bind(Persistence.createEntityManagerFactory("fatburner").createEntityManager()).to(EntityManager.class);
            }
        });
    }
}
