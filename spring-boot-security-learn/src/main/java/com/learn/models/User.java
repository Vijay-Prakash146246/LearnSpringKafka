package com.learn.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity
@Table(name = "user1")
public class User
{
   // @Id
    private  String username;
    private String password;
    private String email;
    //private  String role;
}
