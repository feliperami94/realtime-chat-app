package com.chat.testchat.usecases;

import com.chat.testchat.collections.User;
import com.chat.testchat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * UserUseCase - services
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class UserUseCase {

    private final UserRepository repository;

    /**
     * Find a user by its id
     *
     * @param id String
     * @return User
     */
    private Mono<User> findUserById(String id) {
        return repository.findUserById(id).switchIfEmpty(Mono.error(new Throwable("There's not such user")));
    }

    /**
     * Find a user by its email
     *
     * @param email String
     * @return User
     */
    private Mono<User> findUserByEmail(String email) {
        return repository.findUserByEmail(email).switchIfEmpty(Mono.error(new Throwable("There's not such user")));
    }
}
