package com;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PizzaCornerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldGiveBasicPizza() throws Exception {
        PizzaCorner pizzaCorner = new PizzaCorner(PizzaType.AMERICAN,Base.NORMAL, Crust.THICK, Arrays.asList(TOPPING.BLACKOLIVES));
        String expected = "AMERICAN : 5.0\n" +
                "NORMAL : 0.0\n" +
                "THICK : 0.0\n" +
                "BLACKOLIVES : 0.5\n" +
                "Total Cost is : 5.5";
        assertEquals(expected, pizzaCorner.printBill());
    }

    @Test
    public void shouldGivePizzaWithWheatBase() throws Exception {
        PizzaCorner pizzaCorner = new PizzaCorner(PizzaType.MEXICAN,Base.WHEAT, Crust.THICK, Arrays.asList(TOPPING.BLACKOLIVES));
        String expected = "MEXICAN : 6.0\n" +
                "WHEAT : 1.0\n" +
                "THICK : 0.0\n" +
                "BLACKOLIVES : 0.5\n" +
                "Total Cost is : 7.5";
        assertEquals(expected, pizzaCorner.printBill());
    }

    @Test
    public void shouldGivePizzaWithThinkBase() throws Exception {
        PizzaCorner pizzaCorner = new PizzaCorner(PizzaType.MEXICAN,Base.WHEAT, Crust.THIN, Arrays.asList(TOPPING.BLACKOLIVES));
        String expected = "MEXICAN : 6.0\n" +
                "WHEAT : 1.0\n" +
                "THIN : 0.5\n" +
                "BLACKOLIVES : 0.5\n" +
                "Total Cost is : 8.0";
        assertEquals(expected, pizzaCorner.printBill());
    }

    @Test
    public void shouldGivePizzaWithThinkBaseAndMultipleTopping() throws Exception {
        PizzaCorner pizzaCorner = new PizzaCorner(PizzaType.MEXICAN,Base.WHEAT, Crust.THIN, Arrays.asList(TOPPING.BLACKOLIVES,TOPPING.FRESHTOMATO));
        String expected = "MEXICAN : 6.0\n" +
                "WHEAT : 1.0\n" +
                "THIN : 0.5\n" +
                "BLACKOLIVES : 0.5\n" +
                "FRESHTOMATO : 0.6\n" +
                "Total Cost is : 8.6";
        assertEquals(expected, pizzaCorner.printBill());
    }

    @Test(expected = Exception.class)
    public void shouldNotAllowMoreThanThreeToppings() throws Exception {
        new PizzaCorner(PizzaType.MEXICAN,Base.WHEAT, Crust.THIN, Arrays.asList(TOPPING.JALAPENO,TOPPING.MUSHROOM,TOPPING.CRISPCAPSICUM,TOPPING.FRESHTOMATO));
        thrown.expect(Exception.class);
        thrown.expectMessage("You can choose only 3 toppings");

    }

    @Test(expected = Exception.class)
    public void shouldNotAllowIncompatibleMixOfToppings() throws Exception {
       new PizzaCorner(PizzaType.MEXICAN,Base.WHEAT, Crust.THIN, Arrays.asList(TOPPING.REDPEPPER,TOPPING.MUSHROOM));
        thrown.expect(Exception.class);
        thrown.expectMessage("Please select compatible toppings");
    }

}
