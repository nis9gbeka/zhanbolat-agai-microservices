package bex.packsservice.resources;

import bex.packsservice.models.Packk;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("packks")
public class PacksResource {

    @RequestMapping("/{packkId}")
    public Packk getPackkInfo(@PathVariable("packkId") String packkId){

        return new Packk(packkId, "Testing Name");
    }
}
