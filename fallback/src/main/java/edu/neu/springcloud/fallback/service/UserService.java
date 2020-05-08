package edu.neu.springcloud.fallback.service;

import edu.neu.springcloud.fallback.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "provider", fallbackFactory = edu.neu.springcloud.fallback.config.UserServiceFallbackFactory.class)
@Service
public interface UserService
{

	@RequestMapping(value = "/user/find/{id}", method = RequestMethod.GET)
	User find(@PathVariable("id") int id);
}
