package edu.neu.springcloud.fallback.config;


import edu.neu.springcloud.fallback.bean.User;
import edu.neu.springcloud.fallback.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallbackFactory implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return (UserService) id -> {
            User user = new User();
            user.setId(id);
            user.setLoginName("The user id " + id + " is not found!");
            user.setDbSource("no this data in Database");
            return user;
        };
    }
}

