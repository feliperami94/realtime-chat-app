package com.chat.testchat.controller;

import com.chat.testchat.Dto.MessageDto;
import com.chat.testchat.usecases.MessageUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controller for messages - Rest
 * @author dannielf - feliperami94
 * @version 0.0.1
 * @since 0.0.1
 */
@RestControllerAdvice
@AllArgsConstructor
@RequestMapping(path = "/messages")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
    private final MessageUseCase messageUseCase;

    @GetMapping(path = "/channel/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<MessageDto> findByIdReceiver(@PathVariable("id") String id) {
        return messageUseCase.findByIdReceiver(id);
    }

    @GetMapping(path = "/private/{idSender}/{idReceiver}")
    public Flux<MessageDto> findByIdSenderAndIdReceiver(@PathVariable("idSender") String idSender,
                                                        @PathVariable("idReceiver") String idReceiver) {
        return messageUseCase.findByIdSenderAndIdReceiver(idSender, idReceiver);
    }

    @DeleteMapping(path = "/{id}")
    public Mono<Void> deleteMessageById(@PathVariable("id") String id) {
        return messageUseCase.deleteMessageById(id);
    }
}
