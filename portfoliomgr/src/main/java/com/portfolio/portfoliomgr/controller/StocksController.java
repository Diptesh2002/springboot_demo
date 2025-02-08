package com.portfolio.portfoliomgr.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portfoliomgr.entity.Stocks;
import com.portfolio.portfoliomgr.entity.Users;
import com.portfolio.portfoliomgr.service.StocksService;
@RestController
@RequestMapping("/stocks")
public class StocksController {
@Autowired
private StocksService stocksService;
@GetMapping
public List<Stocks> getAllStocks() {
	return stocksService.getAllStocks();
}
@PostMapping
public ResponseEntity<Stocks> createStock(@RequestParam String stockSymbol,@RequestParam int quantity,@RequestParam Long userId) throws IOException { 
    Users user = new Users();
    user.setUser_id(userId);

    Stocks savedStock = stocksService.saveStock(stockSymbol, quantity, user);
    return ResponseEntity.ok(savedStock);
}


}
