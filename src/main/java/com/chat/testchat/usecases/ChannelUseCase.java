package com.chat.testchat.usecases;

import com.chat.testchat.Dto.ChannelDto;
import com.chat.testchat.collections.Channel;
import com.chat.testchat.mappers.ChannelMapper;
import com.chat.testchat.repository.ChannelRepository;
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
    private final ChannelMapper channelMapper;
    private final ReactiveMongoTemplate mongoTemplate;

    /**
     * Find a channel by its id
     * @param id String
     * @return Channel
     */
    public Mono<Channel> findChannelById(String id) {
        return repository.findChannelById(id).switchIfEmpty(Mono.error(new Throwable("There's no such channel")));
    }

    /**
     * Find a channel by its name
     * @param name String
     * @return Channel
     */
    public Mono<Channel> findChannelByName(String name) {
        return repository.findChannelByName(name).switchIfEmpty(Mono.error(new Throwable("There's no such channel")));
    }

    /**
     *  Find all channels
     * @return Channels
     */

    public Flux<ChannelDto> findAllChannels(){

        return repository.findAll().map(channelMapper::channelToChannelDTO);
    }

    /**
     * Create Channel
     * @param channelDto ChannelDto
     * @return ChannelDto
     */

    public Mono<ChannelDto> createChannel(ChannelDto channelDto){

        return repository.save(channelMapper.channelDTOToChannel(channelDto)).map(channelMapper::channelToChannelDTO);
    }

    /**
     * Delete Channel by its Id
     * @param channelId String
     * @return Void
     */
    public Mono<Void> deleteChannel(String channelId){
        return repository.deleteById(channelId).doOnError(throwable -> Mono.error(throwable.getCause()));
    }


    /**
     * Update Channel
     * @param channelDto ChannelDto
     * @return ChannelDto
     */
    public Mono<ChannelDto> updateChannel(ChannelDto channelDto){
        Query query = new Query().addCriteria(Criteria.where("_id").is(channelDto.getId()));
        Update update = new Update().set("name", channelDto.getName())
                .set("description", channelDto.getDescription());
        return mongoTemplate.findAndModify(query, update, Channel.class).map(channelMapper::channelToChannelDTO);
    }





}
