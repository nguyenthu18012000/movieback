package com.ntt.base.service.impl;

import com.ntt.base.pojo.entity.UserEntity;
import com.ntt.base.pojo.request.UserWriteRequest;
import com.ntt.base.repository.UserRepository;
import com.ntt.base.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Object> findById(long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(user);
    }

    @Override
    public ResponseEntity<Object> createUser(UserWriteRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userRepository.save(userEntity));
    }
}
