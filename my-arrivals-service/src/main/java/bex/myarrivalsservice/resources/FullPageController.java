package bex.myarrivalsservice.resources;

import bex.myarrivalsservice.models.AllAdvantages;
import bex.myarrivalsservice.models.AllHeaders;
import bex.myarrivalsservice.models.FullPage;
import bex.myarrivalsservice.models.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class FullPageController {

    @Autowired
    AdvantagesInfo advantagesInfo;

    @Autowired
    PageInfo pageInfo;

    @CrossOrigin
    @RequestMapping("/{url}")
    public FullPage getFullPage(@PathVariable("url") String url){
        Page page = pageInfo.getPage(url);
        AllHeaders allHeaders = new AllHeaders();
        AllAdvantages allAdvantages = new AllAdvantages();
        if(page.isHeader()) allHeaders = pageInfo.getAllHeaders();
        if(page.isAdvantages()) allAdvantages = advantagesInfo.getAllAdvantages();


        FullPage fullPage = new FullPage(page, allHeaders, allAdvantages);
        return fullPage;
    }

    @PostMapping("/")
    public String testPost(){
        return "works nice";
    }
}
