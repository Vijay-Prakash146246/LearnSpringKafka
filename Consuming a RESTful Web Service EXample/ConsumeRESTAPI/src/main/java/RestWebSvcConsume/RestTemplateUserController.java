package RestWebSvcConsume;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateUserController
{
    @GetMapping("/getAllUsersDetails")
    public ResponseEntity<Object> consumeWebService1() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8085/getAllUsers";
        Object result = restTemplate.getForObject(url, Object.class);
        System.out.println(result);
        return  new ResponseEntity<>(result, HttpStatus.FOUND);
    }

    @PostMapping("/createUser")
    public ResponseEntity<Object> consumeWebService(@RequestBody Object obj)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8085/createUser";
        Object result = restTemplate.postForObject(url, obj, Object.class);
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


}
