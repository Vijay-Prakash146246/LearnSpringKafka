package RestWebSvcConsume;

import com.vijay.User;
import org.springframework.web.client.RestTemplate;

public class MyService {

    private final RestTemplate restTemplate;

    public MyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void consumeWebService() {
        String url = "http://localhost:8087/getAllUsers";
        User response = restTemplate.getForObject(url, User.class);
        System.out.println(response);
    }
}

