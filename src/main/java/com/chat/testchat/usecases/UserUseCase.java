package com.chat.testchat.usecases;

import com.chat.testchat.Dto.UserDto;
import com.chat.testchat.collections.User;
import com.chat.testchat.mappers.UserMapper;
import com.chat.testchat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * UserUseCase - services
 *
 * @author dannielf - feliperami94
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
@AllArgsConstructor
public class UserUseCase {

    private final UserRepository repository;
    private final UserMapper userMapper;
    private final ReactiveMongoTemplate mongoTemplate;

    /**
     * Find a user by its id
     *
     * @param id String
     * @return UserDto
     */
    public Mono<UserDto> findUserById(String id) {
        return repository.findUserById(id).map(userMapper::userToUserDTO)
                .switchIfEmpty(Mono.error(new Throwable("There's not such user")));
    }

    /**
     * Find a user by its email
     *
     * @param email String
     * @return UserDto
     */
    public Mono<UserDto> findUserByEmail(String email) {
        return repository.findUserByEmail(email).map(userMapper::userToUserDTO)
                .switchIfEmpty(Mono.error(new Throwable("There's not such user")));
    }

    /**
     * Find All Users in the Database
     *
     * @return UserDto
     */
    public Flux<UserDto> findAllUsers() {
        return repository.findAll().map(userMapper::userToUserDTO);
    }

    /**
     * Create a User in the Database
     *
     * @param userDto UserDto
     * @return UserDto
     */
    public Mono<UserDto> createUser(UserDto userDto) {
        return repository.save(userMapper.userDTOToUser(userDto)).map(userMapper::userToUserDTO);
    }

    /**
     * Delete a User in the Database by its id
     *
     * @param userId String
     * @return Void
     */
    public Mono<Void> deleteUser(String userId) {
        return repository.deleteById(userId).doOnError(throwable -> Mono.error(throwable.getCause()));
    }


    /**
     * Update User
     * @param userDto UserDto
     * @return UserDto
     */
    public Mono<UserDto> updateUser(UserDto userDto){
        return repository.save(userMapper.userDTOToUser(userDto)).map(userMapper::userToUserDTO);
    }

//    public Mono<UserDto> updateUser(UserDto userDto) {
//        Query query = new Query().addCriteria(Criteria.where("_id").is(userDto.getId()));
//        Update update = new Update().set("userName", userDto.getUserName())
//                .set("email", userDto.getEmail())
//                .set("contacts", userDto.getContacts())
//                .set("isLogged", userDto.getIsLogged())
//                .set("ipAddress", userDto.getIpAddress());
//        return mongoTemplate.findAndModify(query, update, User.class).map(userMapper::userToUserDTO);
//    }



}
