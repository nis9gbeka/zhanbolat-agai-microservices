package bex.myarrivalsservice.resources;

import bex.myarrivalsservice.models.ArrivalItem;
import bex.myarrivalsservice.models.Orderr;
import bex.myarrivalsservice.models.Packk;
import bex.myarrivalsservice.models.UserOrderr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/arrivals")
public class MyArrivalsResourse {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<ArrivalItem> getArrivals(@PathVariable("userId") String userId) {



        UserOrderr orderrs = restTemplate.getForObject("http://orders-server/orderrs/users/" + userId, UserOrderr.class);

        return orderrs.getUserOrderr().stream().map(orderr -> {
            Packk packk = restTemplate.getForObject("http://bexultan-server/packks/" + orderr.getPackkId(), Packk.class);

            return new ArrivalItem(orderr.getCity(), packk.getPackk(), "Test", orderr.getDate_time());
        })
                .collect(Collectors.toList());


//        return Collections.singletonList(
//                new ArrivalItem("Almaty", "Starter packk", "Test", new Date())
//        );
    }
}



            /*Packk packk = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/packks/" + orderr.getPackkId())
                    .retrieve()
                    .bodyToMono(Packk.class)
                    .block();

             */