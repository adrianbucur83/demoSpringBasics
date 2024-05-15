package com.example.demo1.controller;

import com.example.demo1.model.dto.UserCreateDto;
import com.example.demo1.model.dto.UserReturnDto;
import com.example.demo1.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

 private final UserService userService;
@PostMapping
 public UserReturnDto createUser(@RequestBody @Valid UserCreateDto userCreateDto){
   return userService.createUser(userCreateDto);
    }
}
