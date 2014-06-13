package factory;

/**
 * The Factory Method Pattern "defines an interface for creating an object, but
 * lets subclasses decide which class to instantiate. Factory Method lets a
 * class defer instantiation to subclasses.[1]"
 * 
 * Simple Factory isn't a design pattern
 * 
 * [1] Gamma, Erich, et al. Design patterns: elements of reusable
 * object-oriented software. Pearson Education, 1994.
 * 
 * @author Xi Chen
 * 
 */

/*
 * The Creator class contains the implementation for all the methods to
 * manipulate products EXCEPT for the factory method.
 * 
 * e.g. PizzaStore
 */
abstract class Creator {
    /*
     * The factory method that all Creator subclasses must implement
     * 
     * e.g. createPizza()
     */
    abstract Product factoryMethod(int productType);

    // e.g. orderPizza()
    void anOperation(int productType) {
        Product product = factoryMethod(productType);
        product.doSomething();
    }
}

/*
 * The ConcreteCreator creates concrete products. It is the only class that
 * knows how to create these products
 * 
 * e.g. NYPizzaStore
 */
class ConcreteCreator extends Creator {
    // Product type
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;

    @Override
    Product factoryMethod(int productType) {
        switch (productType) {
        case TYPE_ONE:
            return new ConcreteProduct1();
        case TYPE_TWO:
            return new ConcreteProduct2();
        }
        return null;
    }
}

// e.g. Pizza
abstract class Product {
    void doSomething() {
        System.out.println("I'm doing sth...");
    }
}

// e.g. NYStyleCheesePizza
class ConcreteProduct1 extends Product {
    // Might override doSomething
    @Override
    void doSomething() {
        System.out.println("I'm doing sth fancy...");
    }
}

// e.g. ChicagoStyleCheesePizza
class ConcreteProduct2 extends Product {
    // Might add new operations
    void doAnotherThing() {

    }
}
