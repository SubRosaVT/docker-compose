package com.dockercomposr.dockercompose.producers;

import com.dockercomposr.dockercompose.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class VovkProducer {
    private final KafkaTemplate<String, Message> template;


    private final String topic;

    public VovkProducer(KafkaTemplate<String, Message> template,
                        @Value("${spring.kafka.msg.topic.vovk}") String topic) {
        this.template = template;
        this.topic = topic;
    }

    public boolean send(Message msg) throws ExecutionException, InterruptedException {
        try {
            SendResult<String, Message> sendResult = template
                    .send(topic, msg)
                    .get();
            log.info("Create order {} event sent via Kafka", msg);
            log.info(sendResult.toString());
            return true;
        }catch(Exception exception){
            log.error("Failed to send a message {}", msg, exception);
            return false;
        }
    }
}
