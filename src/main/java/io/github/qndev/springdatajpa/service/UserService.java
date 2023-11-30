package io.github.qndev.springdatajpa.service;

import io.github.qndev.springdatajpa.entity.User;
import io.github.qndev.springdatajpa.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "")
    @ResponseBody
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteUserByUserId(String userId) {
        userRepository.deleteUserByIdUsingQuery(userId);
    }

}
