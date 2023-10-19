package com.ayeminoo.algorithmpractice.leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/stock-price-fluctuation/
 *
 */
class StockPrice {
    private Map<Integer, Integer> timePriceMap;
    private SortedMap<Integer, List<Integer>> priceTimeMap;

    private Integer currentPrice;
    private Integer latestTimestamp;


    public StockPrice() {
        timePriceMap = new HashMap<>();
        priceTimeMap = new TreeMap<>();
        latestTimestamp = Integer.MIN_VALUE;
    }
    
    public void update(int timestamp, int price) {

        if(timePriceMap.get(timestamp) != null){
            int oldPrice = timePriceMap.get(timestamp);
            List<Integer> timestampList = priceTimeMap.get(oldPrice);
            timestampList.remove((Object)timestamp);
            if(timestampList.size() == 0){
                priceTimeMap.remove(oldPrice);
            }
        }
        timePriceMap.put(timestamp, price);
        List<Integer> timestampList = priceTimeMap.getOrDefault(price, new ArrayList<>());
        timestampList.add(timestamp);
        priceTimeMap.put(price, timestampList);

        if(latestTimestamp< timestamp){
            latestTimestamp = timestamp;
        }
    }

    public int current() {
        return timePriceMap.get(latestTimestamp);
    }
    
    public int maximum() {
        return priceTimeMap.lastKey();
    }
    
    public int minimum() {
        return priceTimeMap.firstKey();
    }

    public static void main(String[]args){
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
        stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        stockPrice.minimum();     // return 2, the minimum price is 2 at timestamp 4.
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