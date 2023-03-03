package com.zero.admin.panel.service;

import com.zero.admin.panel.dto.request.UserCreateRequest;
import com.zero.admin.panel.entity.User;

public interface UserService {
    User findById(String id);
    void save(UserCreateRequest userCreateRequest);
}
