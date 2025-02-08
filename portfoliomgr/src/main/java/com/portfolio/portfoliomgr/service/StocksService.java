package com.portfolio.portfoliomgr.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfoliomgr.entity.Stocks;
import com.portfolio.portfoliomgr.entity.Users;
import com.portfolio.portfoliomgr.repo.StockRepo;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
@Service
public class StocksService {
@Autowired
private StockRepo stockRepo;

private BigDecimal fetchCurrentStockPrice(String stockSymbol) throws IOException {
Stock stock=YahooFinance.get(stockSymbol);
BigDecimal price = stock.getQuote().getPrice();
return price;
}
public Stocks saveStock(String stockSymbol, int quantity, Users user) throws IOException {
    Stocks stock = new Stocks();
    stock.setStockSymbol(stockSymbol);
    stock.setQuantity(quantity);
    stock.setPurchaseDate(LocalDateTime.now());
    stock.setPurchasePrice(fetchCurrentStockPrice(stockSymbol));

    stock.setUser(user);

    return stockRepo.save(stock);
}
public List<Stocks> getAllStocks() {
    return stockRepo.findAll();
}
}
