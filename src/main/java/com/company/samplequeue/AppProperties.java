package com.company.samplequeue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class AppProperties {
    @Value("${application.queueName}")
    private String queueName;

    public String getQueueName() {
        return queueName;
    }
}
