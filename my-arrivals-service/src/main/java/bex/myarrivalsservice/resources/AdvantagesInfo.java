package bex.myarrivalsservice.resources;

import bex.myarrivalsservice.models.Advantage;
import bex.myarrivalsservice.models.AllAdvantages;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvantagesInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackAdvantagesInfo")
    public AllAdvantages getAllAdvantages(){
        return restTemplate.getForObject("http://localhost:8082/advantages/", AllAdvantages.class);
    }

    public AllAdvantages getFallbackAdvantagesInfo(){
        AllAdvantages allAdvantages = new AllAdvantages();
        Advantage advantage = new Advantage("fallback call", "fallback method caused");
        List<Advantage> advantages = new ArrayList<>();
        advantages.add(advantage);
        allAdvantages.setAllAdvantages(advantages);
        return allAdvantages;
    }
}
