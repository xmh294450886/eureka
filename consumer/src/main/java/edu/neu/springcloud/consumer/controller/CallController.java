package edu.neu.springcloud.consumer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController 
@RequestMapping("consumer")
public class CallController {
    private final static String PROVIDER_URL = "http://localhost:8003/";
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/findAll")
    public Object findAll(){
        return restTemplate.getForObject(PROVIDER_URL + "user/findAll", Object.class);
    }

    @RequestMapping("/find/{id}")
    public Object findByCode(@PathVariable int id){
        return restTemplate.getForObject(PROVIDER_URL + "user/find/" + id, Object.class);
    }
    @RequestMapping("/delete/{id}")
    public Object deleteByCode(@PathVariable int id){
        return restTemplate.getForObject(PROVIDER_URL + "user/delete/" + id, Object.class);
    }

}
