package com.api.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.api.kafka.batchlistener.BatchMessageConsumingExample;
import com.api.kafka.multipartition.MultiPartitionMessagingExample;
import com.api.kafka.simplemessage.SimpleKafkaMessagingExample;
import com.api.kafka.streamapi.KafkaStreamExample;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private SimpleKafkaMessagingExample simpleKafkaMessagingExample;

	/*
	 * @Autowired private MultiPartitionMessagingExample
	 * multiPartitionMessagingExample;
	 * 
	 * @Autowired private BatchMessageConsumingExample batchMessageConsumingExample;
	 * 
	 * @Autowired private KafkaStreamExample kafkaStreamExample;
	 */

    @Bean
    @Profile("!test")
    public CommandLineRunner batchMessageConsumerRunner() {
        return args -> {
            //Just comment out the examples to run
            simpleKafkaMessagingExample.execute();
            //multiPartitionMessagingExample.execute();
            //batchMessageConsumingExample.execute();
            //kafkaStreamExample.execute();
        };
    }
}