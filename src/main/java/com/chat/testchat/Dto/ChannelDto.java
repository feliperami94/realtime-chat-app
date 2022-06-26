package com.chat.testchat.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ChannelDto {
    private String id;
    private String name;
    private String description;
}
