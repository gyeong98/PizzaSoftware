package com.example.project4;

/**
 * This class is to define the object Pepperoni pizza.
 * @author Geon Yeong Kim, Henry Tao
 */
public class Pepperoni extends Pizza{

    /**
     * This constructor is to add basic necessity of Pepperoni Pizza.
     */
    public Pepperoni(){
        toppings.add(Topping.PEPPERONI);
    }

    /**
     * Calculate the price of the pizza for Pepperoni.
     * @return returns the price for the certain mix for Pepperoni.
     */
    @Override
    public double price() {
        int toppingsAmount = toppings.size();
        int extraToppings = toppingsAmount - 2;
        if(size.equals(Size.SMALL)){
            if(toppingsAmount > 1){
                return BASIC_PEPPERONI + extraToppings * EXTRA_TOPPING;
            }
            else{
                return BASIC_PEPPERONI;
            }
        }
        else if(size.equals(Size.MEDIUM)){
            if(toppingsAmount > 1){
                return BASIC_PEPPERONI + extraToppings * EXTRA_TOPPING + Size.MEDIUM.getSize();
            }
            else{
                return BASIC_PEPPERONI + Size.MEDIUM.getSize();
            }
        }
        else if(size.equals(Size.LARGE)){
            if(toppingsAmount > 1){
                return BASIC_PEPPERONI + extraToppings * EXTRA_TOPPING + Size.LARGE.getSize();
            }
            else{
                return BASIC_PEPPERONI + Size.LARGE.getSize();
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
        return super.toString() + "Pepperoni Pizza / Toppings: " + toppings.toString() + " / Size: " + size.toString() + " / Price: " + String.format("%.2f", price()) + "\n";
    }
}
