package com.dockercomposr.dockercompose.consumers;

import com.dockercomposr.dockercompose.dto.Message;
import com.dockercomposr.dockercompose.services.MongoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VovkMessageConsumer {
    private final MongoService mongoService;
    @KafkaListener(topics = "${spring.kafka.msg.topic.vovk}", containerFactory="ContainerFactory")
    public void createOrderListener(@Payload Message msg, Acknowledgment ack) {
        log.info("VovkMessageConsumer received msg {} ", msg);
        try {
            mongoService.save(msg).ifPresentOrElse(
                    (x) -> log.info("Saved the entity {}", x),
                    () -> log.error("Saved failed for {}", msg)
            );
        }catch(Exception exception){
            log.error("Exception on save the entity {}", msg, exception);
        }finally {
            ack.acknowledge();
        }
    }
}
