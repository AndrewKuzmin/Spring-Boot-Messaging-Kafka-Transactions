package com.phylosoft.learning.kafka.listeners;

import com.phylosoft.learning.kafka.configuration.KafkaConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

/**
 * Created by Andrew Kuzmin on 8/14/2021.
 */
public class ListenerB {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConfiguration.class);

    @KafkaListener(id = "fooGroup3", topics = "topic3")
    public void listen2(List<String> in) {
        LOGGER.info("Received: " + in);
    }

}
