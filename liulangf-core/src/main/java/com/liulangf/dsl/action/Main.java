package com.liulangf.dsl.action;

/**
 * This is a copy from <<DSL in Action>> chapter2. 
 * 
 *
 */
public class Main {
    public static void main(String[] args) {
        Order o =
            new Order.Builder()
                     .buy(100, "IBM")
                     .atLimitPrice(300)
                     .allOrNone()
                     .valueAs(new StandardOrderValuer())
                     .build();
        System.out.println(o);
    }
}
