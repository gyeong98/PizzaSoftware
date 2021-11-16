package com.example.project4;

/**
 * This class is to define our Deluxe Pizza
 * @author Geon Yeong Kim, Henry Tao
 */
public class Deluxe extends Pizza {

    /**
     * This is a constructor for Deluxe Pizza which will contain toppings array list of what it has on basics.
     */
    public Deluxe(){
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.ONION);
        toppings.add(Topping.PINEAPPLE);
        toppings.add(Topping.BLACKOLIVES);
        toppings.add(Topping.MUSHROOM);
    }

    /**
     * Calculate the price of the pizza for Deluxe.
     * @return returns the price for the certain mix for Deluxe.
     */
    @Override
    public double price() {
        int toppingsAmount = toppings.size();
        int extraToppings = toppingsAmount - 5;
        if(size.equals(Size.SMALL)){
            if(toppingsAmount > 5){
                return BASIC_DELUXE + extraToppings * EXTRA_TOPPING;
            }
            else{
                return BASIC_DELUXE;
            }
        }
        else if(size.equals(Size.MEDIUM)){
            if(toppingsAmount > 5){
                return BASIC_DELUXE + extraToppings * EXTRA_TOPPING + Size.MEDIUM.getSize();
            }
            else{
                return BASIC_DELUXE + Size.MEDIUM.getSize();
            }
        }
        else if(size.equals(Size.LARGE)){
            if(toppingsAmount > 5){
                return BASIC_DELUXE + extraToppings * EXTRA_TOPPING + Size.LARGE.getSize();
            }
            else{
                return BASIC_DELUXE + Size.LARGE.getSize();
            }
        }
        return 0;
    }

    /**
     * this method returns the string of the print statement for pizza.
     * @return string of the print statement
     */
    @Override
    public String toString() {
        return super.toString() + "Deluxe Pizza / Toppings: " + toppings.toString() + " / Size: " + size.toString() + " / Price: " + String.format("%.2f", price()) + "\n";
    }
}
