package factory;

/**
 * The Abstract Factory Pattern "provides an interface for creating families of
 * related or dependent objects without specifying their concrete classes.[1]"
 * 
 * [1] Gamma, Erich, et al. Design patterns: elements of reusable
 * object-oriented software. Pearson Education, 1994.
 * 
 * @author Xi Chen
 * 
 */

/*
 * Defines the interface that all concrete factories must implement. It consists
 * of a set of methods for producing products.
 */
interface AbstractFactory {
    ProductA1 createProductA1();
    ProductA2 createProductA2();
    ProductB1 createProductB1();
    ProductB2 createProductB2();
}

/*
 * The concrete factories implement the different product families. The client
 * does not need to instantiate a product object (by using key work "new"). It
 * can use one of these factories.
 */
class ConcreteFactory1 implements AbstractFactory {

    @Override
    public ProductA1 createProductA1() {
        return new ProductA1();
    }

    @Override
    public ProductA2 createProductA2() {
        return new ProductA2();
    }

    @Override
    public ProductB1 createProductB1() {
        return new ProductB1();
    }

    @Override
    public ProductB2 createProductB2() {
        return new ProductB2();
    }

}

class ConcreteFactory2 implements AbstractFactory {

    @Override
    public ProductA1 createProductA1() {
        return new ProductA1();
    }

    @Override
    public ProductA2 createProductA2() {
        return new ProductA2();
    }

    @Override
    public ProductB1 createProductB1() {
        return new ProductB1();
    }

    @Override
    public ProductB2 createProductB2() {
        return new ProductB2();
    }

}

// Product family. Each concrete factory can produce an entire set of products
abstract class AbstractProductA { }

class ProductA1 extends AbstractProductA { }

class ProductA2 extends AbstractProductA { }

abstract class AbstractProductB { }

class ProductB1 extends AbstractProductB { }

class ProductB2 extends AbstractProductB { }

// Uses only interfaces declared by AbstractFactory and AbstractProduct classes
class Client {
    ConcreteFactory1 factory = null;
    public Client(ConcreteFactory1 factory) {
        this.factory = factory;
    }
    
    // An example using factory methods to produce products
    void prepare() {
        factory.createProductA1();
        factory.createProductA2();
        factory.createProductB1();
        factory.createProductB2();
    }
}