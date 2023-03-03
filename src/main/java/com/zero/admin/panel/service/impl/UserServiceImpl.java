package com.zero.admin.panel.service.impl;

import com.zero.admin.panel.constant.Message;
import com.zero.admin.panel.dto.request.UserCreateRequest;
import com.zero.admin.panel.entity.Role;
import com.zero.admin.panel.entity.User;
import com.zero.admin.panel.error.InternalServerException;
import com.zero.admin.panel.error.NotFoundException;
import com.zero.admin.panel.repository.UserRepository;
import com.zero.admin.panel.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(String id) {
        User user = this.userRepository.findById(UUID.fromString(id)).get();
        if(user == null){
            throw new NotFoundException(Message.USER_NOT_FOUND);
        }
        return user;
    }

    @Override
    public void save(UserCreateRequest userCreateRequest) {
        try{
            User user = User
                    .builder()
                    .id(UUID.randomUUID())
                    .name(userCreateRequest.getName())
                    .email(userCreateRequest.getEmail())
                    .password(userCreateRequest.getPassword())
                    .city(userCreateRequest.getCity())
                    .state(userCreateRequest.getState())
                    .country(userCreateRequest.getCountry())
                    .occupation(userCreateRequest.getOccupation())
                    .phoneNumber(userCreateRequest.getPhoneNumber())
                    .transactions(userCreateRequest.getTransactions())
                    .role(Role.valueOf(userCreateRequest.getRole()))
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .build();
            this.userRepository.save(user);
        } catch (ConstraintViolationException e){
            log.error("Error : " + e.getMessage());
            throw new InternalServerException("Email already exist...");
        }

    }
}
