package com.chat.testchat.controller;

import com.chat.testchat.Dto.ChannelDto;
import com.chat.testchat.Dto.UserDto;
import com.chat.testchat.usecases.UserUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserUseCase userUseCase;
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDto> getAllUsers(){
        return userUseCase.findAllUsers();
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDto> createUser(@RequestBody UserDto userDto){
        return userUseCase.createUser(userDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable("id") String userId){
        return userUseCase.deleteUser(userId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserDto> updateUser(@RequestBody UserDto userDto){
        return userUseCase.updateUser(userDto);
    }
}
