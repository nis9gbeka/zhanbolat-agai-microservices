package bex.myarrivalsservice.resources;

import bex.myarrivalsservice.models.ArrivalItem;
import bex.myarrivalsservice.models.Orderr;
import bex.myarrivalsservice.models.Packk;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArrivalInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackArrivalItem",
            threadPoolKey = "ArrivalInfoPool",
            threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public ArrivalItem getArrivalItem(Orderr orderr) {
        Packk packk = restTemplate.getForObject("http://bexultan-server/packks/" + orderr.getPackkId(), Packk.class);
        return new ArrivalItem(orderr.getCity(), packk.getPackk(), "Test", orderr.getDate_time());
    }
    public ArrivalItem getFallbackArrivalItem(Orderr orderr) {
        return new ArrivalItem(orderr.getCity(), "Pack not found", "Test", null);
    }
}
