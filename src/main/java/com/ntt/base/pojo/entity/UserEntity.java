package com.ntt.base.pojo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    private String username;
    private String password;

    private boolean isActive = Boolean.TRUE;

    private String avatar;

    private Date dateOfBirth;

    private String gender;

    @CreationTimestamp
    private Timestamp createAt;

    @CreationTimestamp
    private Timestamp updateAt;

    private Timestamp deleteAt;
}
