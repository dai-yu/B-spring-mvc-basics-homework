package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();


    public void register(User user) {
        if (isExist(user)) {

        }
        userMap.put(user.getUsername(),user);
    }

    private boolean isExist(User user) {
        return userMap.containsKey(user.getUsername());
    }


}
