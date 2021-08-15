package com.phylosoft.learning.kafka.listeners;

import com.phylosoft.learning.kafka.configuration.KafkaConfiguration;
import com.phylosoft.learning.kafka.domain.Foo2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by Andrew Kuzmin on 8/14/2021.
 */
@Service
public class ListenerA {

    private final Logger LOGGER = LoggerFactory.getLogger(ListenerA.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ListenerA(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(id = "fooGroup2", topics = "topic2")
    public void listen1(List<Foo2> foos) throws IOException {
        LOGGER.info("Received: " + foos);
        foos.forEach(f -> kafkaTemplate.send("topic3", f.getFoo().toUpperCase()));
    }

}
