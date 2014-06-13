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
    void createPart1();

    void createPart2();
}

/*
 * The concrete factories implement the different product families. The client
 * does not need to instantiate a product object (by using key workd "new"). It
 * can use one of these factories.
 */
class ConcreteFactory1 implements AbstractFactory {

    @Override
    public void createPart1() {
        // TODO Auto-generated method stub

    }

    @Override
    public void createPart2() {
        // TODO Auto-generated method stub

    }

}

class ConcreteFactory2 implements AbstractFactory {

    @Override
    public void createPart1() {
        // TODO Auto-generated method stub

    }

    @Override
    public void createPart2() {
        // TODO Auto-generated method stub

    }

}

abstract class ProductA {
    String name;
    
    // Suppose the materials needed in prepare() comes from different factories.
    abstract void prepare();
    
    void otherOperations() {
        System.out.println("There are other same standard operations");
    }
}

class ProductA1 extends ProductA {

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        
    }
    
}

class ProductA2 extends ProductA {

    @Override
    void prepare() {
        // TODO Auto-generated method stub

    }
    
}