package com.portfolio.portfoliomgr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfoliomgr.entity.Stocks;



public interface StockRepo extends JpaRepository<Stocks,Long> {
}
