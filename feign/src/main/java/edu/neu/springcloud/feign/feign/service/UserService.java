package edu.neu.springcloud.feign.feign.service;

import edu.neu.springcloud.feign.feign.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
@FeignClient("provider")
public interface UserService {

    @RequestMapping("/user/find/{id}")
    User find(@PathVariable int id);

    @RequestMapping("/user/delete/{id}")
    void delete(@PathVariable int id);

    @RequestMapping("/user/findAll")
    List<User> findAll();

    @RequestMapping("/user/insert/{loginName}&{username}&{password}&{dbSource}")
    void insert(@PathVariable String loginName,@PathVariable String username,@PathVariable String password,@PathVariable String dbSource);

    @RequestMapping("/user/set/{id}&{loginName}&{username}&{password}&{dbSource}")
    void set(@PathVariable int id,@PathVariable String loginName,@PathVariable String username,@PathVariable String password,@PathVariable String dbSource);

}
