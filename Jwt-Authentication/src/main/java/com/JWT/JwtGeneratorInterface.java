package com.JWT;

import com.JWT.entities.User;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component

public interface JwtGeneratorInterface
{
    Map<String, String> generateToken(User user);
}
