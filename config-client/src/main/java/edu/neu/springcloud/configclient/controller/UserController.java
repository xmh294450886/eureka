package edu.neu.springcloud.configclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.neu.springcloud.configclient.domain.User;
import edu.neu.springcloud.configclient.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserController {

    @Resource
    UserService userService;


    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/user/find/{id}")
    public User find(@PathVariable("id") int id) throws Exception {
        User user = userService.find(id);

        if (user==null) throw new Exception();
        else {
            user.setIdentification("provider1");
            return user;
        }
    }

    public User fallback(@PathVariable("id") int id){
        User user = new User();
        user.setId(id);
        user.setLoginName("The user id " + id + " is not found!");
        user.setDbSource("no this data in Database");
        return user;
    }
    @RequestMapping("/user/delete/{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "success delete in provider1";
    }

    @RequestMapping("/user/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }


    @RequestMapping("/user/insert/{loginName}&{username}&{password}&{dbSource}")
    public String insert(@PathVariable String loginName,@PathVariable String username,@PathVariable String password,@PathVariable String dbSource){
        User user = new User();
        user.setLoginName(loginName);
        user.setUsername(username);
        user.setPassword(password);
        user.setDbSource(dbSource);
        userService.insert(user);
        return "success insert in provider1";
    }
    @RequestMapping("/user/set/{id}&{loginName}&{username}&{password}&{dbSource}")
    public String set(@PathVariable int id,@PathVariable String loginName,@PathVariable String username,@PathVariable String password,@PathVariable String dbSource){
        User user=userService.find(id);
        user.setLoginName(loginName);
        user.setUsername(username);
        user.setPassword(password);
        user.setDbSource(dbSource);
        userService.set(user);
        return "success set in provider1";
    }

}
