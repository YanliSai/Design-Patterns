package factory;

/**
 * The Factory Method Pattern "defines an interface for creating an object, but
 * lets subclasses decide which class to instantiate. Factory Method lets a
 * class defer instantiation to subclasses." [1]
 * 
 * [1] Gamma, Erich, et al. Design patterns: elements of reusable
 * object-oriented software. Pearson Education, 1994.
 * 
 * @author Xi Chen
 * 
 */
public class FactoryMethod {
    // Product type
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;

    /*
     * Creator contains the implementation for all the methods to manipulate
     * products except for the factory method.
     */
    abstract class Creator {
        // The factory method that all Creator subclasses must implement
        abstract Product factoryMethod(int productType);

        void anOperation(int productType) {
            Product product = factoryMethod(productType);
            product.doSomething();
        }
    }

    /*
     * The ConcreteCreator creates concrete products. It is the only class
     * that knows how to create these products
     */
    class ConcreteCreator extends Creator {

        @Override
        Product factoryMethod(int productType) {
            switch (productType) {
            case TYPE_ONE:
                return new ConcreteProductOne();
            case TYPE_TWO:
                return new ConcreteProductTwo();
            }
            return null;
        }
    }

    abstract class Product {
        void doSomething() {
            System.out.println("I'm doing sth...");
        }
    }

    class ConcreteProductOne extends Product {
        // Might override doSomething
        @Override
        void doSomething() {
            System.out.println("I'm doing sth fancy...");
        }
    }

    class ConcreteProductTwo extends Product {
        // Might add new operations
        void doAnotherThing() {
            
        }
    }
}
