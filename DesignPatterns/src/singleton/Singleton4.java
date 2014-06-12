/**
 * 
 */
package singleton;

/**
 * "double-checked locking". Check if an instance is created. If not, we
 * synchronize.
 * 
 * @author Xi Chen
 *
 */
public class Singleton4 {
    
    /* 
     * "volatile" key word guarantees the variable will have one main copy. 
     * By using it, when many threads are accessing the same object and one 
     * thread makes a change, the change will be updated to other threads.
     */
    private volatile static Singleton4 instance;
    
    private Singleton4() {}
    
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) { // Once in the block, "double check" it.
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
