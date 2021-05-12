package com.api.kafka.streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class SimpleKafkaMessageConsumerForStreaming {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleKafkaMessageConsumerForStreaming.class);

    @KafkaListener(topics = "${kafka.topic.streamProcessedDataTopic}")
    public void receive(String payload) {
        LOGGER.info("Received payload='{}'", payload);
    }
}
