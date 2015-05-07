package com;

public enum Base {
    WHEAT {
        @Override
        double getCost() {
            return 1;
        }
    },
    NORMAL {
        @Override
        double getCost() {
            return 0;
        }
    };
    abstract double getCost() ;

}

