//package com.learn.services;
//
//import com.learn.models.User;
//import com.learn.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService
//{
//    @Autowired
//    private UserRepo userRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //Optional<User> user = this.userRepo.findById(username);
//        User user1 = this.userRepo.getById(username);
//        if(user1==null)
//            throw  new UsernameNotFoundException("No User");
//        return  new CustomUserDetail(user1);
//    }
//}
