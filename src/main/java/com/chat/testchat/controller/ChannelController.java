package com.chat.testchat.controller;

import com.chat.testchat.usecases.ChannelUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class ChannelController {

    private final ChannelUseCase channelUseCase;
    private static Logger logger = LoggerFactory.getLogger(ChannelController.class);
}
