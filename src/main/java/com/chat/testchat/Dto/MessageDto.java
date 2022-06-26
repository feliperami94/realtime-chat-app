package com.chat.testchat.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class MessageDto {
    private String id;
    private String idSender;
    private String idReceiver;
    private String message;
    private Instant creationDate;
    private Status status;
    private Boolean isSeen;

}
