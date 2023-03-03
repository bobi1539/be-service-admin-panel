package com.zero.admin.panel.dto.request;

import com.zero.admin.panel.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {

    private String name;

    private String email;

    private String password;

    private String city;

    private String state;

    private String country;

    private String occupation;

    private String phoneNumber;

    private String transactions;

    private String role;
}
