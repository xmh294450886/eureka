package edu.neu.springcloud.configclient2.service;

import edu.neu.springcloud.configclient2.domain.User;
import edu.neu.springcloud.configclient2.repository.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User find(int id) {
        return userMapper.find(id);
    }

    @Override
    public void delete(int id){
        userMapper.delete(id);
    }

    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Override
    public void insert(User user){
        userMapper.insert(user);
    }
    @Override
    public void set(User user){
        userMapper.set(user);
    }
}
