package com.vijay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private  UserSvc userSvc;
    @Autowired
    private  UserRepo userRepo;
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1 = userRepo.save(user);
        return  new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    @GetMapping("/getAllUsers")
    public  ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        users = userSvc.getAllUsers();
        return  new ResponseEntity<>(users,HttpStatus.OK);
    }
}
