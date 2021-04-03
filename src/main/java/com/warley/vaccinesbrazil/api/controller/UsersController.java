package com.warley.vaccinesbrazil.api.controller;

import com.warley.vaccinesbrazil.api.entitys.user.Users;
import com.warley.vaccinesbrazil.api.entitys.user.requests.UserPostRequestBody;
import com.warley.vaccinesbrazil.api.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Users> saveUser(@RequestBody UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(usersService.saveUser(userPostRequestBody), HttpStatus.CREATED);
    }

}
