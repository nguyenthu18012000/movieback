package com.ntt.base.controller;

import com.ntt.base.pojo.request.UserWriteRequest;
import com.ntt.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody UserWriteRequest request) {
        return userService.createUser(request);
    }
}
