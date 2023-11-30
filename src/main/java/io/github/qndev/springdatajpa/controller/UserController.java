package io.github.qndev.springdatajpa.controller;

import io.github.qndev.springdatajpa.entity.User;
import io.github.qndev.springdatajpa.service.AddressService;
import io.github.qndev.springdatajpa.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final AddressService addressService;

    private final UserService userService;

    public UserController(AddressService addressService, UserService userService) {
        this.addressService = addressService;
        this.userService = userService;
    }

    @GetMapping(path = "/detail/{userId}")
    @ResponseBody
    public User findUser(@PathVariable String userId) {
        return userService.findUser(userId);
    }

    @GetMapping(path = "/list")
    @ResponseBody
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @PostMapping(path = "/update/{userId}")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping(path = "/delete/{userId}")
    @Transactional(rollbackOn = {RuntimeException.class})
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUserByUserId(userId);
        addressService.deleteAddressByUserId(userId);

        // throw new RuntimeException();
    }

}
