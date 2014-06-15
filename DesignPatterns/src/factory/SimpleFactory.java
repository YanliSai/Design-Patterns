package factory;

/**
 * Simple Factory is not a actual design pattern (not one of 23 design
 * patterns in GOF book). It is also called static factory method.
 * 
 * @author Xi Chen
 * 
 */

enum CarBrand {
    BMW, BENZ, AUDI
}

abstract class Car {
    private CarBrand brand;
    
    public Car(CarBrand brand) {
        this.brand = brand;
    }
    
    public CarBrand getBrand() {
        return brand;
    }
}

class BMWCar extends Car {
    public BMWCar() {
        super(CarBrand.BMW);
    }        
}

class BENZCar extends Car {
    public BENZCar() {
        super(CarBrand.BENZ);
    }
}

class AUDICar extends Car {
    public AUDICar() {
        super(CarBrand.AUDI);
    }
}

/*
 * Implement simple factory. It instantiates a car instance only after
 * determining its brand
 */
class CarFactory {
    public static Car makeCar(CarBrand brand) {
        switch (brand) {
        case BMW:
            return new BMWCar();
        case BENZ:
            return new BENZCar();
        case AUDI:
            return new AUDICar();
        }
        return null;
    }
}
