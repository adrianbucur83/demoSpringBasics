package com.example.demo1.service;

import com.example.demo1.model.User;
import com.example.demo1.model.dto.UserCreateDto;
import com.example.demo1.model.dto.UserReturnDto;
import com.example.demo1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

        public UserReturnDto createUser(UserCreateDto userCreateDto) {
            User user = new User();
            user.setFirstName(userCreateDto.getFirstName());
            user.setLastName(userCreateDto.getLastName());
          //  String encodedPassword = passwordEncoder.encode(userCreateDto.getPassword());
            user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
            user.setUsername(userCreateDto.getUsername());
            user.setEmail(userCreateDto.getEmail());
         //   User saveUser = userRepository.save(user);
            userRepository.save(user);

            return new UserReturnDto(user.getFirstName(), user.getLastName(), user.getId());
        }
}
