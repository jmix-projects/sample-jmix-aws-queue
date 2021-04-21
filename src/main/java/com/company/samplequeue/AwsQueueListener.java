package com.company.samplequeue;

import org.slf4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/application.properties")
public class AwsQueueListener {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AwsQueueListener.class);

    // Listen queue or list of queues.
    // Queues can be defined by their logical/physical name or URL.
    // In other hand your can use
    // @SqsListener(value = "${application.queueName}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    // MessageMapping always use policy SqsMessageDeletionPolicy.ALWAYS
    @MessageMapping(value = "${application.queueName}")
    public void listen(Message<String> message) {
        log.info("Received message, Payload: {}, Message: {}", message.getPayload(), message);
    }
}
