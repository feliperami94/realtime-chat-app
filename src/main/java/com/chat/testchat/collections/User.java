package com.chat.testchat.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String userName;
    private String email;
    private List<String> contacts;
}
