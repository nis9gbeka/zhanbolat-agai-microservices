package bex.ordersservice.resources;

import bex.ordersservice.models.Orderr;
import bex.ordersservice.models.UserOrderr;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orderrs")
public class OrdersResource {

    @RequestMapping("/{packkId}")
    public Orderr getOrderr(@PathVariable("packkId") String packkId){
        return new Orderr(packkId, "no city", new Date());
    }


    @RequestMapping("users/{userId}")
    public UserOrderr getUserOrderr(@PathVariable("userId") String userId){


        List<Orderr> orderrs = Arrays.asList(
                new Orderr("1234", "Almaty", new Date()),
                new Orderr("5678", "Astana", new Date())
        );

        UserOrderr userOrderr = new UserOrderr();
        userOrderr.setUserOrderr(orderrs);

        return userOrderr;
    }
}
