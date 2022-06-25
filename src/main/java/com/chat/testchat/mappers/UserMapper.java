package com.chat.testchat.mappers;

import com.chat.testchat.Dto.UserDto;
import com.chat.testchat.collections.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto userToUserDTO(User user){
        return new UserDto(
          user.getId(),
          user.getUserName(),
          user.getEmail(),
          user.getContacts()
        );
    }

    public User userDTOToUser(UserDto userDto){
        return new User(
          userDto.getId(),
          userDto.getUserName(),
          userDto.getEmail(),
          userDto.getContacts()
        );
    }
}
