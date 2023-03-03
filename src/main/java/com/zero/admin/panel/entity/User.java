package com.zero.admin.panel.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "m_user")
public class User {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String city;

    private String state;

    private String country;

    private String occupation;

    private String phoneNumber;

    private String transactions;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Date createdAt;

    private Date updatedAt;
}
