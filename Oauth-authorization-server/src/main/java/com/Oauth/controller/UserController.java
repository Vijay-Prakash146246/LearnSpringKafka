package com.Oauth.controller;

import com.Oauth.models.User;
import com.Oauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;
    //all users
    @GetMapping("/getAllUsers")
    public List<User>getAllUsers()
    {
        return this.userService.getAllUsers();
    }

   // @PreAuthorize("hasRole('ADMIN')")
   //return single user
   //this method is only used by admin
    @GetMapping("/getUser/{username}")
    public  User getUser(@PathVariable("username")String username)
    {
        return  this.userService.getUser(username);
    }
    @PostMapping("/createUser")
    public  User add(@RequestBody User user)
    {
        return  this.userService.addUser(user);
    }

}
