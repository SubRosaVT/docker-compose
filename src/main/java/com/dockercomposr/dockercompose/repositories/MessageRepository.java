package com.dockercomposr.dockercompose.repositories;

import com.dockercomposr.dockercompose.entities.MessageEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface MessageRepository  extends CrudRepository<MessageEntity,String> {
    @Query("{id:'?0'}")
    MessageEntity findItemById(String id);
    Stream<MessageEntity> findAllBy();
}
