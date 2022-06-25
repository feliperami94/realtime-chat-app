package com.chat.testchat.repository;

import com.chat.testchat.collections.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MessageRepository extends ReactiveMongoRepository<Message, String> {

    Flux<Message> findByIdReceiver(String id);

    Flux<Message> findByIdSenderAndIdReceiver(String idSender, String idReceiver);
}
