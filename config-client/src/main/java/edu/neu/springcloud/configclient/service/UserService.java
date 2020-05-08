package edu.neu.springcloud.configclient.service;

import edu.neu.springcloud.configclient.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

    User find(int id);
    void delete(int id);


    List<User> findAll();

    void insert(User user);
    void set(User user);

}
