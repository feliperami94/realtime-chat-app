package com.chat.testchat.Dto;

import java.time.Instant;

public class MessageDto {
    private String id;
    private String idSender;
    private String idReceiver;
    private String content;
    private Instant date;
    private Status status;
    private Boolean isSeen;
}
