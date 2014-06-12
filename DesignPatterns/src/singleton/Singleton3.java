/**
 * 
 */
package singleton;

/**
 * This implementation is thread safe. If the application always create an
 * instance, this one can be used.
 * 
 * @author Xi Chen
 *
 */
public class Singleton3 {
    
    // JVM create the instance when the class is loaded. It guarantees thread safety
    private static Singleton3 instance = new Singleton3();
    
    private Singleton3() {}
    
    public static Singleton3 getInstance() {
        return instance;
    }
}
