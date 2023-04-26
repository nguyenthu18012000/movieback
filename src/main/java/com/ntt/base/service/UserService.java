package com.ntt.base.service;

import com.ntt.base.pojo.request.UserWriteRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> findById(long id);
    ResponseEntity<Object> createUser(UserWriteRequest request);
}
