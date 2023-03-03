package com.zero.admin.panel.controller;

import com.zero.admin.panel.constant.EndPoint;
import com.zero.admin.panel.dto.request.UserCreateRequest;
import com.zero.admin.panel.dto.response.ResponseWithData;
import com.zero.admin.panel.entity.User;
import com.zero.admin.panel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndPoint.USER)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequest request){
        this.userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body( new ResponseWithData<UserCreateRequest>(
                        201, "Create User Successfully...", request
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") String id){
        User user = this.userService.findById(id);
        return ResponseEntity.ok(
                new ResponseWithData<User>(200, "User is found...", user)
        );
    }
}
