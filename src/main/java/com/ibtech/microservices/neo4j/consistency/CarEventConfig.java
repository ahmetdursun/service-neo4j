package com.ibtech.microservices.neo4j.consistency;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarEventConfig {



    @Bean(name = "neo4jCar")
    public Queue neo4jCarUpdatedQueue() {
        return new Queue("neo4j_car_updated_queue");
    }

    @Bean(name = "carCreated")
    public Queue carCreatedQueue() {
        return new Queue("car_created_queue");
    }

    @Bean(name = "carUpdated")
    public Queue carUpdatedQueue() {
        return new Queue("car_updated_queue");
    }

    @Bean(name = "carDeleted")
    public Queue carDeletedQueue() {
        return new Queue("car_deleted_queue");
    }
}
