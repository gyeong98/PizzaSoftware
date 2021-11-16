package com.example.project4;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeluxeTest extends Pizza {

    @Test
    public void testPrice() {
        Pizza testPizza = new Deluxe();
        testPizza.size = Size.LARGE;
        assertTrue(String.format("%.2f", testPizza.price()).equals(String.valueOf(16.99)));

        Pizza testPizza2 = new Deluxe();
        testPizza.size = Size.MEDIUM;
        assertTrue(String.format("%.2f", testPizza.price()).equals(String.valueOf(14.99)));

        Pizza testPizza3 = new Deluxe();
        testPizza.size = Size.SMALL;
        assertTrue(String.format("%.2f", testPizza.price()).equals(String.valueOf(12.99)));

        Pizza testPizza4 = new Deluxe();
        testPizza.size = Size.LARGE;
        testPizza.toppings.add(Topping.PINEAPPLE);
        testPizza.toppings.add(Topping.GREENPEPPER);
        assertTrue(String.format("%.2f", testPizza.price()).equals(String.valueOf(19.97)));

        Pizza testPizza5 = new Deluxe();
        testPizza.size = Size.LARGE;
        testPizza.toppings.remove(Topping.PEPPERONI);
        testPizza.toppings.remove(Topping.MUSHROOM);
        assertTrue(String.format("%.2f", testPizza.price()).equals(String.valueOf(16.99)));
    }

    @Test
    public void testToString() {
    }

    @Override
    public double price() {
        return 0;
    }
}