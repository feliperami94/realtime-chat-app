package com.chat.testchat.mappers;

import com.chat.testchat.Dto.UserDto;
import com.chat.testchat.collections.User;
import org.springframework.stereotype.Component;

/**
 * UserMapper
 *
 * @author feliperami94
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class UserMapper {

    public UserDto userToUserDTO(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getContacts(),
                user.getIsLogged(),
                user.getIpAddress()
        );
    }

    public User userDTOToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getContacts(),
                userDto.getIsLogged(),
                userDto.getIpAddress()
        );
    }
}
