package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginInformationErrorException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNameExistException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    public void register(User user) {
        if (isExist(user)) {
            throw new UserNameExistException("username already exists");
        }
        user.setId(userMap.size() + 1);
        userMap.put(user.getUsername(), user);
    }

    private boolean isExist(User user) {
        return userMap.containsKey(user.getUsername());
    }


    public User login(String username, String password) {
        if (userMap.get(username) != null && userMap.get(username).getPassword().equals(password)) {
            return userMap.get(username);
        }else{
            throw new LoginInformationErrorException("wrong user name or password");
        }
    }
}
