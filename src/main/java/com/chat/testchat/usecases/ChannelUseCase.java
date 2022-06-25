package com.chat.testchat.usecases;

import com.chat.testchat.collections.Channel;
import com.chat.testchat.repository.ChannelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * ChannelUseCase - services
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class ChannelUseCase {

    private final ChannelRepository repository;

    /**
     * Find a channel by its id
     * @param id String
     * @return Channel
     */
    private Mono<Channel> findChannelById(String id) {
        return repository.findChannelById(id).switchIfEmpty(Mono.error(new Throwable("There's no such channel")));
    }

    /**
     * Find a channel by its name
     * @param name String
     * @return Channel
     */
    private Mono<Channel> findChannelByName(String name) {
        return repository.findChannelByName(name).switchIfEmpty(Mono.error(new Throwable("There's no such channel")));
    }
}
