package edu.neu.springcloud.fallback.controller;



import edu.neu.springcloud.fallback.bean.User;
import edu.neu.springcloud.fallback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/user/find/{id}")
    public User find(@PathVariable("id") int id){

        return userService.find(id);
    }
}
