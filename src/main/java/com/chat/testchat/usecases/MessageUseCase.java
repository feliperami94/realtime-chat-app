package com.chat.testchat.usecases;

import com.chat.testchat.Dto.MessageDto;
import com.chat.testchat.collections.Message;
import com.chat.testchat.collections.User;
import com.chat.testchat.mappers.MessageMapper;
import com.chat.testchat.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

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
    private final ReactiveMongoTemplate mongoTemplate;

    /**
     * Find messages by channel id
     *
     * @param id String
     * @return Flux[Message]
     */
    public Flux<MessageDto> findAllByIdReceiver(String id) {
        return repository.findAllByIdReceiver(id)
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
    public Flux<MessageDto> findAllByIdSenderAndIdReceiver(String idSender, String idReceiver) {
        return repository.findAllByIdSenderAndIdReceiver(idSender, idReceiver)
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


    /**
     * Update Message
     * @param messageDto MessageDto
     * @return MessageDto
     */

    public Mono<MessageDto> updateMessage(MessageDto messageDto) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(messageDto.getId()));
        Update update = new Update().set("message", messageDto.getMessage())
                .set("creationDate", Instant.now())
                .set("status", messageDto.getStatus())
                .set("isSeen", messageDto.getIsSeen());
        return mongoTemplate.findAndModify(query, update, Message.class).map(mapper::messageToMessageDTO);
    }
}
