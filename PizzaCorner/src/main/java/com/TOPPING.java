package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TOPPING {
    BLACKOLIVES {
        @Override
        double getCost() {
            return 0.5;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Collections.emptyList();
        }
    },
    CRISPCAPSICUM {
        @Override
        double getCost() {
            return 0.5;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Collections.emptyList();
        }
    },
    MUSHROOM {
        @Override
        double getCost() {
            return 0.5;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Arrays.asList(REDPEPPER);
        }
    },
    GOLDENCORN {
        @Override
        double getCost() {
            return 0.5;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Collections.emptyList();
        }
    },
    PINEAPPLE {
        @Override
        double getCost() {
            return 0.6;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Arrays.asList(JALAPENO);
        }
    },
    FRESHTOMATO {
        @Override
        double getCost() {
            return 0.6;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Collections.emptyList();
        }
    },
    JALAPENO {
        @Override
        double getCost() {
            return 0.75;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Arrays.asList(PINEAPPLE);
        }
    },
    REDPEPPER {
        @Override
        double getCost() {
            return 0.75;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Arrays.asList(MUSHROOM);
        }
    },
    GHERKINSBABYCORN {
        @Override
        double getCost() {
            return 0.75;
        }

        @Override
        List<TOPPING> inCompatibleTopping() {
            return Collections.emptyList();
        }
    };

    abstract  double getCost();
    abstract List<TOPPING> inCompatibleTopping();

}
