package com.vijay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateUserController
{
    @GetMapping("/getAllUsersDetails")
    public ResponseEntity<Object> consumeWebService1() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8087/getAllUsers";
        Object result = restTemplate.getForObject(url, Object.class);
        System.out.println(result);
        return  new ResponseEntity<>(result, HttpStatus.FOUND);
    }

    @PostMapping("/createUser")
    public ResponseEntity<Object> consumeWebService(@RequestBody Object obj)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8087/createUser";
        Object result = restTemplate.postForObject(url, obj, Object.class);
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/createUser1")
    public ResponseEntity<Object> consumeWebService2()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8087/createUser";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "Amit Kumar");
        requestBody.put("address", "Kolhapur");

        Object result = restTemplate.postForObject(url, requestBody, Object.class);
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
