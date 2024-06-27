package com.dockercomposr.dockercompose.services;

import com.dockercomposr.dockercompose.dto.Message;
import com.dockercomposr.dockercompose.entities.MessageEntity;
import com.dockercomposr.dockercompose.repositories.MessageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MongoService {
    private final MessageRepository messageRepository;
    private final MongoTemplate mongoTemplate;
    static private final String MESSAGES_COLLECTION = "messages";

    @PostConstruct
    private void lazyInit(){
        createCollectionIfNotExists();
    }

    private void createCollectionIfNotExists() {
        try {
            if (!mongoTemplate.collectionExists(MongoService.MESSAGES_COLLECTION)) {
                mongoTemplate.createCollection(MongoService.MESSAGES_COLLECTION);
                log.info("Collection {} created.", MongoService.MESSAGES_COLLECTION);
            } else {
                log.info("Collection {} already exists.", MongoService.MESSAGES_COLLECTION);
            }
        }catch (Exception exception){
            log.error("Failed to validate {} ", MongoService.MESSAGES_COLLECTION,exception);
        }
    }

    public Optional<Message> save(Message message){
      return  asOptionalMessage(messageRepository.save(asEntity(message))) ;
    }

    public Optional<Message> getById(String id){
        try {
            MessageEntity res = messageRepository.findItemById(id);
            return asOptionalMessage(res);
        }
        catch(Exception exception){
            log.error("Failed to find by id {}", id, exception);
            return Optional.empty();
        }
    }



    private MessageEntity asEntity(Message message){
       return MessageEntity.builder()
                .msg(message.getMsg())
                .id(message.getId())
                .build();
    }

    private Optional<Message> asOptionalMessage(MessageEntity entity){
        if(Objects.isNull(entity)){
            return Optional.empty();
        }
        return Optional.of(Message.builder()
                .msg(entity.getMsg())
                .id(entity.getId())
                .build());
    }
}
