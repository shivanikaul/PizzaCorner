package com;

import java.util.List;

public class PizzaCorner {
    private final PizzaType type;
    private final Base base;
    private final Crust crust;
    private final List<TOPPING> toppings;
    private static final String COLON=" : ";
    private static final String TOTAL_COST = "Total Cost is";
    private static final String  NEW_LINE = "\n";

    public PizzaCorner(PizzaType type, Base base, Crust crust, List<TOPPING> toppings) throws Exception {
        this.type = type;
        this.base = base;
        this.crust = crust;
        this.toppings = toppings;
        validateToppings();
    }

    private void validateToppings() throws Exception {
        validateNumberOfToppings();
        validateIncompatibleToppings();
    }

    private void validateIncompatibleToppings() throws Exception {
        for (TOPPING topping : toppings) {
            List<TOPPING> inCompatibleToppings = topping.inCompatibleTopping();
            for (TOPPING inCompatibleTopping : inCompatibleToppings) {
                if(toppings.contains(inCompatibleTopping)) throw new Exception("Please select compatible toppings");
            }
        }
    }

    private void validateNumberOfToppings() throws Exception {
        if(toppings.size() > 3)
            throw  new Exception("You can choose only 3 toppings");
    }

    public String printBill() {
        double totalCost = calculateTotalCost();
        return getBillDetails(totalCost);
    }

    private String getBillDetails(double totalCost) {
        StringBuilder billDetails = new StringBuilder();
        billDetails.append(type).append(COLON).append(type.getBaseCost()).append(NEW_LINE);
        billDetails.append(base).append(COLON).append(base.getCost()).append(NEW_LINE);
        billDetails.append(crust).append(COLON).append(crust.getCost()).append(NEW_LINE);
        for (TOPPING topping : toppings) {
            billDetails.append(topping).append(COLON).append(topping.getCost()).append(NEW_LINE);
        }
        billDetails.append(TOTAL_COST).append(COLON).append(totalCost);
        return billDetails.toString();
    }

    private double calculateTotalCost() {
        double totalBill = type.getBaseCost() + base.getCost()+ crust.getCost() ;
        for (TOPPING topping : toppings) {
            totalBill += topping.getCost();
        }
        return totalBill;
    }


}
