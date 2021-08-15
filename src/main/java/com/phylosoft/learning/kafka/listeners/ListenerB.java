package com.phylosoft.learning.kafka.listeners;

import com.phylosoft.learning.kafka.configuration.KafkaConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andrew Kuzmin on 8/14/2021.
 */
@Service
public class ListenerB {

    private final Logger LOGGER = LoggerFactory.getLogger(ListenerB.class);

    @KafkaListener(id = "fooGroup3", topics = "topic3")
    public void listen2(List<String> in) {
        LOGGER.info("Received: " + in);
    }

}
