package com.chat.testchat.usecases;

import com.chat.testchat.collections.Message;
import com.chat.testchat.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * MessageUseCase - services
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class MessageUseCase {

    private final MessageRepository repository;

    /**
     * Find messages by channel id
     * @param id String
     * @return Flux[Message]
     */
    private Flux<Message> findByIdReceiver(String id) {
        return repository.findByIdReceiver(id).switchIfEmpty(Mono.error(new Throwable("There's no such channel id")));
    }

    /**
     * Find messages by sender id and  receiver id
     * @param idSender String
     * @param idReceiver String
     * @return Flux[Message]
     */
    private Flux<Message> findByIdSenderAndIdReceiver(String idSender, String idReceiver) {
        return repository.findByIdSenderAndIdReceiver(idSender, idReceiver)
                .switchIfEmpty(Mono.error(new Throwable("There's no such user id")));
    }
}
