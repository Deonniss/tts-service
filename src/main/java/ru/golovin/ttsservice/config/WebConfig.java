package ru.golovin.ttsservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${spring.mvc.static-path-pattern}")
    private String fileStoragePattern;

    @Value("${spring.web.resources.static-locations}")
    private String fileStorageLocation;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileStoragePattern).addResourceLocations(fileStorageLocation);
    }
}
