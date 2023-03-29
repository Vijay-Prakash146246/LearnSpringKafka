package com.vijay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSvc
{
    @Autowired
    private  UserRepo userRepo;
    public List<User>getAllUsers()
    {
        List<User> userList = new ArrayList<>();
        userRepo.findAll().forEach(userList::add);
        return userList;
    }
}
