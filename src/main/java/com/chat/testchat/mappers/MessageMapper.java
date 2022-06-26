package com.chat.testchat.mappers;

import com.chat.testchat.Dto.MessageDto;
import com.chat.testchat.collections.Message;
import org.springframework.stereotype.Component;

/**
 * MessageMapper
 * @author feliperami94
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class MessageMapper {

    public MessageDto messageToMessageDTO(Message message){
        return new MessageDto(
                message.getId(),
                message.getIdSender(),
                message.getIdReceiver(),
                message.getMessage(),
                message.getCreationDate(),
                message.getStatus(),
                message.getIsSeen()
        );
    }

    public Message messageDTOToMessage(MessageDto messageDto){
        return new Message(
                messageDto.getId(),
                messageDto.getIdSender(),
                messageDto.getIdReceiver(),
                messageDto.getMessage(),
                messageDto.getCreationDate(),
                messageDto.getStatus(),
                messageDto.getIsSeen()
        );
    }
}
