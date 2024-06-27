package com.dockercomposr.dockercompose.controllers;

import com.dockercomposr.dockercompose.dto.Message;
import com.dockercomposr.dockercompose.producers.VovkProducer;
import com.dockercomposr.dockercompose.services.MongoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
public class DemoController {

    private final VovkProducer vovkProducer;
    private final MongoService mongoService;

    @SneakyThrows
    @GetMapping("/msg")
    public String get() {
        Message msg = Message.builder()
                .id(UUID.randomUUID().toString())
                .msg("secure")
                .build();

        String res = msg.toString() + " " + vovkProducer.send(msg);
        log.info(res);
        return res;
    }
    @SneakyThrows
    @GetMapping("/msg-db/{id}")
    public String getNyId(@PathVariable String id) {
        String res = mongoService.getById(id).orElse(new Message()).toString();
        log.info(res);
        return res;
    }


}
