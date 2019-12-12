package bex.ordersservice.resources;


import bex.ordersservice.models.AllHeaders;
import bex.ordersservice.models.Headers;
import bex.ordersservice.models.Page;
import bex.ordersservice.repository.PageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pages")
public class HController {

    private PageRepository pageRepository;

    public HController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @CrossOrigin
    @GetMapping("/{url}")
    public Page a(@PathVariable("url") String url){
        Page c = pageRepository.findByUrl(url);

        return c;
    }

    @GetMapping("/test")
    public String test(){
        return "Works Good";
    }

    @CrossOrigin
    @GetMapping("/headers")
    public AllHeaders getHeaders(){
        List<Page> pages = pageRepository.findAll();
        List<Headers> headers = new ArrayList<>();
        for (int i=0; i<pages.size(); i++){
            Headers header = new Headers(pages.get(i).getName(), pages.get(i).getUrl());
            headers.add(header);
        }
        AllHeaders allHeaders = new AllHeaders();
        allHeaders.setHeaders(headers);
        return allHeaders;
    }

//    @PostMapping("/set/")
//    public Page x(@PathVariable("{url}") String url, Page page){
//        Page currentPage = pageRepository.findByUrl(url);
//        currentPage = new Page(page);
//    }
}
