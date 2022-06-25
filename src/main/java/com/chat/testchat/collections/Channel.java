package com.chat.testchat.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Channel {

    @Id
    private String id;
    private String name;
    private String description;
}
