package com.portfolio.portfoliomgr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfoliomgr.entity.Users;

public interface UserRepo extends JpaRepository<Users, Long>{

}
