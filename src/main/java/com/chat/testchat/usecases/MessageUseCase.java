package com.chat.testchat.usecases;

import com.chat.testchat.Dto.MessageDto;
import com.chat.testchat.mappers.MessageMapper;
import com.chat.testchat.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * MessageUseCase - services
 *
 * @author dannielf
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class MessageUseCase {

    private final MessageRepository repository;
    private final MessageMapper mapper;

    /**
     * Find messages by channel id
     *
     * @param id String
     * @return Flux[Message]
     */
    public Flux<MessageDto> findByIdReceiver(String id) {
        return repository.findByIdReceiver(id)
                .map(mapper::messageToMessageDTO)
                .switchIfEmpty(Mono.error(new Throwable("There's no such channel id")));
    }

    /**
     * Find messages by sender id and  receiver id
     *
     * @param idSender   String
     * @param idReceiver String
     * @return Flux[Message]
     */
    public Flux<MessageDto> findByIdSenderAndIdReceiver(String idSender, String idReceiver) {
        return repository.findByIdSenderAndIdReceiver(idSender, idReceiver)
                .map(mapper::messageToMessageDTO)
                .switchIfEmpty(Mono.error(new Throwable("There's no such user id")));
    }

    /**
     * Create a new message
     *
     * @param message MessageDto
     * @return MessageDto
     */
    public Mono<MessageDto> createMessage(MessageDto message) {
        return repository.save(mapper.messageDTOToMessage(message))
                .map(mapper::messageToMessageDTO);
    }

    /**
     * Delete message by its id
     *
     * @param id String
     * @return Void
     */
    public Mono<Void> deleteMessageById(String id) {
        return repository.deleteById(id)
                .doOnError(throwable -> Mono.error(throwable.getCause()));
    }
}
