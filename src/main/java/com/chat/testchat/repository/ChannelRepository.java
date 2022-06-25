package com.chat.testchat.repository;

import com.chat.testchat.collections.Channel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ChannelRepository extends ReactiveMongoRepository<Channel, String> {

    Mono<Channel> findChannelById(String id);

    Mono<Channel> findChannelByName(String name);
}
