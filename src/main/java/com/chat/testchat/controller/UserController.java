package com.chat.testchat.controller;

import com.chat.testchat.Dto.UserDto;
import com.chat.testchat.usecases.UserUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
@CrossOrigin(origins = "*")
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

    @GetMapping(path = "/userEmail/{email}")
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

    @DeleteMapping(value = "/deleteUser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable("id") String userId) {
        return userUseCase.deleteUser(userId);
    }
}
