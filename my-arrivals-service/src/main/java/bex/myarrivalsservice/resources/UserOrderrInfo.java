package bex.myarrivalsservice.resources;

import bex.myarrivalsservice.models.Orderr;
import bex.myarrivalsservice.models.UserOrderr;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserOrderrInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserOrders")
    public UserOrderr getUserOrders(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://orders-server/orderrs/users/" + userId, UserOrderr.class);
    }
    public UserOrderr getFallbackUserOrders(@PathVariable("userId") String userId) {
        UserOrderr userOrderr = new UserOrderr();
        userOrderr.setUserOrderr(Arrays.asList(new Orderr("","",null)));
        return userOrderr;
    }
}
