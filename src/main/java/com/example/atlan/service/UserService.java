package com.example.atlan.service;

import com.example.atlan.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

public class UserService {

    private List<User> store=new ArrayList<>();

    public UserService() {
        store.add(new User(UUID.randomUUID().toString(),"Harsh Tiwari","harshtiwari@gmail.com"));
    }

    public List<User> getStore() {
        return store;
    }

    public void setStore(List<User> store) {
        this.store = store;
    }
}
