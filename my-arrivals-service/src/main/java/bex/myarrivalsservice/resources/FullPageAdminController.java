package bex.myarrivalsservice.resources;


import bex.myarrivalsservice.models.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FullPageAdminController {

    @Autowired
    PageInfo pageInfo;

    @Autowired
    AdvantagesInfo advantagesInfo;

    @PostMapping("/{url}")
    public Page setFullPage(@PathVariable("url") String url, Page page){
        Page pageResponse = pageInfo.setPage(url, page);
        return pageResponse;
    }
}
