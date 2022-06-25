package com.chat.testchat.controller;

import com.chat.testchat.collections.Message;
import com.chat.testchat.repository.MessageRepository;
import lombok.AllArgsConstructor;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
@AllArgsConstructor
public class ChatController {


    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageRepository repository;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
        System.out.println(message);
        message.setDate(Instant.now());
        repository.save(message).subscribe();
        return message;
    }

    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message){
        message.setDate(Instant.now());
        simpMessagingTemplate.convertAndSendToUser(message.getIdReceiver(),"/private",message);

        System.out.println(message);
        repository.save(message).subscribe();
        return message;
    }
}
