package com.chat.testchat.controller;

import com.chat.testchat.Dto.ChannelDto;
import com.chat.testchat.usecases.ChannelUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@AllArgsConstructor
@RequestMapping(value = "/channel")
public class ChannelController {

    private final ChannelUseCase channelUseCase;
    private static Logger logger = LoggerFactory.getLogger(ChannelController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ChannelDto> getAllChannels(){
        return channelUseCase.findAllChannels();
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ChannelDto> createChannel(@RequestBody ChannelDto channelDto){
        return channelUseCase.createChannel(channelDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteChannel(@PathVariable("id") String channelId){
        return channelUseCase.deleteChannel(channelId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ChannelDto> updateChannel(@RequestBody ChannelDto channelDto){
        return channelUseCase.updateChannel(channelDto);
    }
}
