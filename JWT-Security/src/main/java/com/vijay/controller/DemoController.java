package com.vijay.controller;

import com.vijay.repo.UserRepository;
import com.vijay.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo-controller")
public class DemoController
{
    private  final UserRepository userRepository;
    @GetMapping
    public ResponseEntity<String> sayHello()
    {
        return  ResponseEntity.ok("Hello from secured end point");
    }
    @PostMapping("/createUser")
    public  ResponseEntity<User>createUser(@RequestBody User user)
    {
        userRepository.save(user);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/List-of-users")
    public ResponseEntity<List<User>> users()
    {
        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.FOUND) ;
    }
    @GetMapping("/getById/{id}")
    public  ResponseEntity<User> getUserById(@PathVariable("id") Integer id)
    {
        Optional<User> user = userRepository.findById(id);
        return  new ResponseEntity<>(user.get(),HttpStatus.FOUND);
    }
    @PutMapping("updateById/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id,@RequestBody User user)
    {
        user.setId(id);
        Optional<User> exitingUser = userRepository.findById(id);
        exitingUser.get().setFirstname(user.getFirstname());
        exitingUser.get().setLastname(user.getLastname());
        exitingUser.get().setEmail(user.getEmail());
        exitingUser.get().setPassword(user.getPassword());
        User user1 =  userRepository.save(exitingUser.get());
        return  new ResponseEntity<>(user1,HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable("id") Integer id)
    {
        userRepository.deleteById(id);
        return  new ResponseEntity<>("User Sucessfully get deleted",HttpStatus.OK);
    }
}
