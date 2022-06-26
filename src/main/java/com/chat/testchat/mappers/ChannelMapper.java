package com.chat.testchat.mappers;

import com.chat.testchat.Dto.ChannelDto;
import com.chat.testchat.collections.Channel;
import org.springframework.stereotype.Component;

/**
 * ChannelMapper
 * @author feliperami94
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class ChannelMapper {

    public ChannelDto channelToChannelDTO(Channel channel){
        return new ChannelDto(
                channel.getId(),
                channel.getName(),
                channel.getDescription()
        );
    }

    public Channel channelDTOToChannel(ChannelDto channelDto){
        return new Channel(
                channelDto.getId(),
                channelDto.getName(),
                channelDto.getDescription()
        );
    }
}
