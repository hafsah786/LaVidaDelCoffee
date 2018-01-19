package com.smithjterm.lavidadelcoffee;

import android.util.Log;

import java.util.HashMap;

/**
 * a class that uses HashMap to store "type of coffee" and its point
 */

public class CoffeePoint {
    public static HashMap<String, Integer> coffeeMap = new HashMap<String, Integer>();

    //the type of coffee that has the maximum point
    public static String maxPoint = "Latte";

    /**
     * initialize the point of each coffee to 0
     */
    public CoffeePoint() {
        coffeeMap.put("Latte", 0);
        coffeeMap.put("Cappuccino", 0);
        coffeeMap.put("Mocha", 0);
        coffeeMap.put("Americano", 0);
        coffeeMap.put("Espresso", 0);
        coffeeMap.put("Macchiato", 0);
    }

    /**
     * @return the point of a certain type of coffee
     */
    public int getPoint(String string) {
        return coffeeMap.get(string);
    }

    /**
     * add one point to a certain type of coffee
     * @param string: the type of coffee
     */
    public void add(String string) {
        int newPoint = getPoint(string)+1;
        coffeeMap.remove(string);
        coffeeMap.put(string, newPoint);
    }

}
