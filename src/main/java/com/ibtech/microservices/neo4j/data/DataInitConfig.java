package com.ibtech.microservices.neo4j.data;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitConfig {

    @Autowired
    private DataInitService dataInitService;

    @Bean
    public InitializingBean initDatasource() {
        return () -> {
            dataInitService.clearDatabase();
            dataInitService.load();
        };
    }
}
