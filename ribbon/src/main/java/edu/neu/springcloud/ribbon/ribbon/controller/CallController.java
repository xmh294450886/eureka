package edu.neu.springcloud.ribbon.ribbon.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class CallController {
    private final static String PROVIDER_URL = "http://provider/";
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/findAll")
    public Object findAll(){
        return restTemplate. getForObject(PROVIDER_URL + "user/findAll", Object.class);
    }

    @RequestMapping("/find/{id}")
    public Object findByCode(@PathVariable String id){
        return restTemplate.getForObject(PROVIDER_URL + "user/find/" + id, Object.class);
    }
    @RequestMapping("/insert/{loginName}&{username}&{password}&{dbSource}")
    public String insert(@PathVariable String loginName,@PathVariable String username,@PathVariable String password,@PathVariable String dbSource) {
        return restTemplate.getForObject(PROVIDER_URL + "user/insert/" + loginName + "&" + username + "&" + password + "&" + dbSource, String.class);
    }
    @RequestMapping("/set/{id}&{loginName}&{username}&{password}&{dbSource}")
    public String set(@PathVariable int id,@PathVariable String loginName,@PathVariable String username,@PathVariable String password,@PathVariable String dbSource){
        return restTemplate.getForObject(PROVIDER_URL + "user/set/"+id+"&" + loginName + "&" + username + "&" + password + "&" + dbSource, String.class);
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return restTemplate.getForObject(PROVIDER_URL+"user/delete/"+id,String.class);
    }

}
