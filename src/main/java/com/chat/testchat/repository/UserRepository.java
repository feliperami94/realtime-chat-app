package com.chat.testchat.repository;

import com.chat.testchat.collections.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findUserById(String id);
    Mono<User> findUserByEmail(String email);
}
