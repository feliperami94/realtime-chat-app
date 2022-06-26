package com.chat.testchat.controller;

import com.chat.testchat.Dto.UserDto;
import com.chat.testchat.usecases.UserUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controller for users
 *
 * @author dannielf - feliperami94
 * @version 0.0.1
 * @since 0.0.1
 */
@RestControllerAdvice
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserUseCase userUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<UserDto> getAllUsers() {
        return userUseCase.findAllUsers();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserDto> getUserById(@PathVariable("id") String id) {
        return userUseCase.findUserById(id);
    }

    @GetMapping(path = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<UserDto> getUserByEmail(@PathVariable("email") String email) {
        return userUseCase.findUserByEmail(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDto> createUser(@RequestBody UserDto userDto) {
        return userUseCase.createUser(userDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<UserDto> updateUser(@RequestBody UserDto userDto) {
        return userUseCase.updateUser(userDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable("id") String userId) {
        return userUseCase.deleteUser(userId);
    }
}
