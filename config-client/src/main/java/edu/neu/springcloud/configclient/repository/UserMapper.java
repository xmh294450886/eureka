package edu.neu.springcloud.configclient.repository;

import edu.neu.springcloud.configclient.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select id,loginName,username,password,dbSource from user where id=#{id}")
    User find(int id);
    @Delete("delete from user where id=#{id}")
    void delete(int id);
    @Select("select * from user")
    List<User> findAll();
    @Insert("insert into user (loginName,username,password,dbSource) values(#{loginName},#{username},#{password},#{dbSource})")
    void insert(User user);
    @Update("update user set loginName=#{loginName},username=#{username},password=#{password},dbSource=#{dbSource} where id=#{id}")
    void set(User user);
}
