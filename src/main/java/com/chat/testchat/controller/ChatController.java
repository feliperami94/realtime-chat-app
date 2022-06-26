package com.chat.testchat.controller;

import com.chat.testchat.Dto.MessageDto;
import com.chat.testchat.usecases.MessageUseCase;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * Controller for messages - websocket
 * @author dannielf - feliperami94
 * @version 0.0.1
 * @since 0.0.1
 */
@Controller
@AllArgsConstructor
public class ChatController {


    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageUseCase useCase;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Mono<MessageDto> receiveMessage(@Payload MessageDto message) {
        System.out.println(message);
        message.setCreationDate(Instant.now());
        return useCase.createMessage(message);
    }

    @MessageMapping("/private-message")
    public Mono<MessageDto> recMessage(@Payload MessageDto message) {
        message.setCreationDate(Instant.now());
        simpMessagingTemplate.convertAndSendToUser(message.getIdReceiver(), "/private", message);

        System.out.println(message);
        return useCase.createMessage(message);
    }


}
