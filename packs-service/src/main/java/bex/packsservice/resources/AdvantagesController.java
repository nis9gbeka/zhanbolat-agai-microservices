package bex.packsservice.resources;

import bex.packsservice.models.Advantage;
import bex.packsservice.models.AllAdvantages;
import bex.packsservice.repository.AdvantagesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/advantages")
public class AdvantagesController {
    private AdvantagesRepository advantagesRepository;

    public AdvantagesController(AdvantagesRepository advantagesRepository){
        this.advantagesRepository = advantagesRepository;
    }

    @GetMapping("/")
    public AllAdvantages getAdvantages(){
        AllAdvantages allAdvantages = new AllAdvantages();
        List<Advantage> advantages = advantagesRepository.findAll();
        allAdvantages.setAllAdvantages(advantages);
        return allAdvantages;
    }
}
