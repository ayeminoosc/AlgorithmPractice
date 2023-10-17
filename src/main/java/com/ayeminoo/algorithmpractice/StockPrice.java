package com.ayeminoo.algorithmpractice;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/stock-price-fluctuation/
 */
class StockPrice {
    private Map<Integer, Integer> stockPriceMap;
    private Map<Integer, Integer> priceCount;

    private Integer currentPrice;
    private Integer maximumPrice;
    private Integer minimumPrice;

    public StockPrice() {
        stockPriceMap = new HashMap<>();
        maximumPrice = Integer.MIN_VALUE;
        minimumPrice = Integer.MAX_VALUE;
    }
    
    public void update(int timestamp, int price) {

        if(stockPriceMap.get(timestamp) != null){
            correct(timestamp, price);
        }else{
            add(timestamp, price);
        }
//        maximumPrice = Math.max(maximumPrice, price);
//        minimumPrice = Math.min(minimumPrice, price);
    }

    private void correct(int t, int p){
        currentPrice = p;
        Integer oldPrice = stockPriceMap.get(t);
        stockPriceMap.put(t, p);

        if(p != oldPrice && p > maximumPrice){
            maximumPrice = p;
            priceCount.put(p, 1);
            priceCount.put(oldPrice, priceCount.get(oldPrice) - 1);
        }else if(p != oldPrice && oldPrice.equals(maximumPrice)){

        }

    }

    private void add(int t, int p){
        currentPrice = p;
        maximumPrice = Math.max(maximumPrice, p);
        minimumPrice = Math.min(minimumPrice, p);
        priceCount.put(p, priceCount.getOrDefault(p, 0) + 1);
    }
    
    public int current() {
        return currentPrice;
    }
    
    public int maximum() {
        return maximumPrice;
    }
    
    public int minimum() {
        return minimumPrice;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */