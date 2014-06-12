/**
 * 
 */
package singleton;

/**
 * This implementation is not thread safe
 * 
 * @author Xi Chen
 *
 */
public class Singleton1 {
    private static Singleton1 instance;
    
    private Singleton1() {}
    
    public static Singleton1 getInstance() {
        if (instance == null) {
            return new Singleton1();
        }
        return instance;
    }
}
