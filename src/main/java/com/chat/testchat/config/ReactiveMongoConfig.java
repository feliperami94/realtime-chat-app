package com.chat.testchat.config;


import com.mongodb.reactivestreams.client.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

/**
 * ReactiveMongoConfig - ReactiveMongoTemplate
 *
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
@AllArgsConstructor
public class ReactiveMongoConfig {

    private final MongoClient mongoClient;

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient, "chat_db");
    }

}
