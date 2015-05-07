package com;

public enum PizzaType {
   AMERICAN() {
       @Override
       double getBaseCost() {
           return 5;
       }
   },INDIAN() {
        @Override
        double getBaseCost() {
            return 4;
        }
    },MEXICAN() {
        @Override
        double getBaseCost() {
            return 6;
        }
    };
   private double price;
   abstract  double getBaseCost();

}
