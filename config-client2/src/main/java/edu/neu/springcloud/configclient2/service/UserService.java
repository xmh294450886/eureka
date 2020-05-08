package edu.neu.springcloud.configclient2.service;

import edu.neu.springcloud.configclient2.domain.User;

import java.util.List;

public interface UserService {

    User find(int id);
    void delete(int id);


    List<User> findAll();

    void insert(User user);
    void set(User user);

}
