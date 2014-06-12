/**
 * 
 */
package singleton;

/**
 * This implementation is thread safe, but not efficient as synchronization is
 * expensive
 * 
 * @author Xi Chen
 *
 */
public class Singleton2 {
    private static Singleton2 instance;
    
    private Singleton2() {}
    
    /*
     * "synchronized" key word forces every thread to wait its turn before
     * it can enter the method 
     */
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            return new Singleton2();
        }
        return instance;
    }
}
