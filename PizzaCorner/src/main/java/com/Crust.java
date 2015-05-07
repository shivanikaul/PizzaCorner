package com;

public enum Crust {
    THICK {
        @Override
        double getCost() {
            return 0;
        }
    },
    THIN {
        @Override
        double getCost() {
            return 0.5;
        }
    },
    PAN {
        @Override
        double getCost() {
            return -0.75;
        }
    };
    abstract double getCost();

}
