package edu.neu.springcloud.feign.feign.controller;

import edu.neu.springcloud.feign.feign.bean.User;
import edu.neu.springcloud.feign.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class CallController {
    private final static String PROVIDER_URL = "http://provider/";
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping("/find/{id}")
    public User findByCode(@PathVariable int id){
        return userService.find(id);
    }

    @RequestMapping("/user/delete/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
    @RequestMapping("/insert/{loginName}&{username}&{password}&{dbSource}")
    public void insert(@PathVariable String loginName,@PathVariable String username,@PathVariable String password,@PathVariable String dbSource){
        userService.insert(loginName,username,password,dbSource);
    }
    @RequestMapping("/set/{id}&{loginName}&{username}&{password}&{dbSource}")
    public void set(@PathVariable int id,@PathVariable String loginName,@PathVariable String username,@PathVariable String password,@PathVariable String dbSource){
        userService.set(id,loginName,username,password,dbSource);
    }




}
