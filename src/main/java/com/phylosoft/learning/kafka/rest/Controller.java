package com.phylosoft.learning.kafka.rest;

import com.phylosoft.learning.kafka.domain.Foo1;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrew Kuzmin on 8/14/2021.
 */
@RestController
public class Controller {

    private final KafkaTemplate<Object, Object> template;

    public Controller(KafkaTemplate<Object, Object> template) {
        this.template = template;
    }

    @PostMapping(path = "/send/foos/{what}")
    public void sendFoo(@PathVariable String what) {
        this.template.executeInTransaction(kafkaTemplate -> {
            StringUtils.commaDelimitedListToSet(what).stream()
                    .map(Foo1::new)
                    .forEach(foo -> kafkaTemplate.send("topic2", foo));
            return null;
        });
    }

}
