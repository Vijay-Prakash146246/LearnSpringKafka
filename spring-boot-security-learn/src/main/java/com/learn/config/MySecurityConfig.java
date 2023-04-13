package com.learn.config;
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
//@EnableGlobalAuthentication
public class MySecurityConfig
{
    //for DB Access
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
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
//    @Autowired
//    private UserRepo userRepository;
//
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//
//        // Create in-memory user details
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder.encode("user"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("USER", "ADMIN")
//                .build();
//
//        UserDetails onlyadmin = User.withUsername("onlyadmin")
//                .password(passwordEncoder.encode("onlyadmin"))
//                .roles("ADMIN")
//                .build();
//
//        // Add in-memory user details to the inMemoryUserDetailsManager
//        inMemoryUserDetailsManager.createUser(user);
//        inMemoryUserDetailsManager.createUser(admin);
//        inMemoryUserDetailsManager.createUser(onlyadmin);
//
//        // Create a custom implementation of UserDetailsService
//        return username -> {
//           //UserDetails userDetails = inMemoryUserDetailsManager.loadUserByUsername(username);
//            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
//
//            if (userDetails == null) {
//                //User userFromDb = userRepository.findByUsername(username);
//                com.learn.models.User userFromDb = userRepository.getById(username);
//                if (userFromDb == null) {
//                    throw new UsernameNotFoundException("User not found");
//                }
//                userDetails = User.builder()
//                        .username(userFromDb.getUsername())
//                        .password(userFromDb.getPassword())
//                        //.roles(userFromDb.getRole().toArray(new String[0]))
//                        .roles(userFromDb.getRole())
//                        .build();
//            }
//            return userDetails;
//        };
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //or no password incoder
        return encoder;
    }
}
