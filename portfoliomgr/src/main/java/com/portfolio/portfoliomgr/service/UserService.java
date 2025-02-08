package com.portfolio.portfoliomgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfoliomgr.entity.Users;
import com.portfolio.portfoliomgr.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Users createUser(Users users) {
        return userRepo.save(users);
    }

    public Users getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
