package bex.myarrivalsservice.resources;


import bex.myarrivalsservice.models.ArrivalItem;
import bex.myarrivalsservice.models.UserOrderr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/arrivals")
public class MyArrivalsResourse {

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    ArrivalInfo arrivalInfo;

    @Autowired
    UserOrderrInfo userOrderrInfo;

    @RequestMapping("/{userId}")
    public List<ArrivalItem> getArrivals(@PathVariable("userId") String userId) {
        UserOrderr orderrs = userOrderrInfo.getUserOrders(userId);

        return orderrs.getUserOrderr().stream()
                .map(orderr -> arrivalInfo.getArrivalItem(orderr))
                .collect(Collectors.toList());
    }

}
