package com.JWT;

import com.JWT.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public User getUserByNameAndPassword(String name, String password) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameAndPassword(name, password);
        if(user == null){
            throw new UsernameNotFoundException("Invalid id and password");
        }
        return user;
    }
}
