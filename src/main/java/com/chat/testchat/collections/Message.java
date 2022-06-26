package com.chat.testchat.collections;

import com.chat.testchat.Dto.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    private String id;
    private String idSender;
    private String idReceiver;
    private String message;
    private Instant creationDate;
    private Status status; //TODO Optional
    private Boolean isSeen;
}
