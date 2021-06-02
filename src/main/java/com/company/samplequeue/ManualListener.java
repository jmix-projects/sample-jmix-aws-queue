package com.company.samplequeue;

import io.jmix.simplequeue.api.MessageQueueHandler;
import io.jmix.simplequeue.api.QueueManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ManualListener {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ManualListener.class);

    public ManualListener(QueueManager commonQueueManager) {
        MessageQueueHandler handler1 = (result) -> {
            log.info("handler 1: ");
            result.getMessages().forEach(m -> log.info(m.getBody()));
        };
        commonQueueManager.subscribe("jmixqueues_jmixQueue", handler1);

        MessageQueueHandler handler2 = (result) -> {
            log.info("handler 2: ");
            result.getMessages().forEach(m -> log.info(m.getBody()));
        };
        commonQueueManager.subscribe("jmixqueues_jmixQueue", handler2);
    }
}
