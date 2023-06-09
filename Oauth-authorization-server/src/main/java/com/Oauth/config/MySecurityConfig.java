package com.Oauth.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //You can use authorizeHttpRequests instead of authorizeRequests and requestMatchers instead of antMatchers.
        http
                .csrf().disable()//Now because of it admin will able to create user

                //for it we have required to pass X-XSRF-TOKEN in side postman header this is not working
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()

                //.authorizeRequests()
                .authorizeHttpRequests()
               //.requestMatchers("/home","/login","/register").permitAll()
                //.requestMatchers("/public/**").permitAll() //means public sa start hona wala sara url ko permit karna hai
                .requestMatchers("/public/**").hasRole("USER")
                .requestMatchers("/users/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                //.httpBasic(); //for basic authentication
                .formLogin();//for form based authentication
                //.loginPage("/signin");//for manual configuratio of page
        return http.build();
    }
    //Role - High level view -> Normal : read
    //Authority: permission
    //admin :- read write delete
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER", "ADMIN")
                .build();

        UserDetails onlyadmin = User.withUsername("onlyadmin")
                .password(passwordEncoder.encode("onlyadmin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //or no password incoder
        return encoder;
    }
}
