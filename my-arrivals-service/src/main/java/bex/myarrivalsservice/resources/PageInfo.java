package bex.myarrivalsservice.resources;

import bex.myarrivalsservice.models.AllHeaders;
import bex.myarrivalsservice.models.Page;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class PageInfo {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackPageInfo")
    public Page getPage(@PathVariable("url") String url){
        return restTemplate.getForObject("http://localhost:8083/pages/"+url, Page.class);
    }

    public Page getFallbackPageInfo(@PathVariable("url") String url) {
        return new Page("not found", "not found", "not found", "not found", url, "not found", false, false, false, false);
    }

    @HystrixCommand(fallbackMethod = "getFallbackPageInfoHeaders",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public AllHeaders getAllHeaders(){
        return restTemplate.getForObject("http://localhost:8083/pages/headers", AllHeaders.class);
    }

    public AllHeaders getFallbackPageInfoHeaders(){
        return null;
    }

    @HystrixCommand(fallbackMethod = "getFallbackSetPageInfo")
    public Page setPage(@PathVariable("url") String url, Page page){
        return restTemplate.getForObject("http://localhost:8083/pages/set/"+page, Page.class);
    }

    public Page getFallbackSetPageInfo(@PathVariable("url") String url, Page page) {
        return new Page("not found", "not found", "not found", "not found", url, "not found", false, false, false, false);
    }

}