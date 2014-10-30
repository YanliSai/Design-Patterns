package singleton;

/**
 * "double-checked locking pattern (DCLP)". Check if an instance is created. If not, we
 * synchronize.
 * 
 * @author Xi Chen
 *
 */
class Singleton {
    
    /* 
     * "volatile" key word guarantees the variable will have one main copy. 
     * By using it, when many threads are accessing the same object and one 
     * thread makes a change, the change will be updated to other threads.
     */
    private static volatile Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) { // Lock only if instance is null
            synchronized (Singleton.class) {
                if (instance == null) { // Once in the block, "double check" it.
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

/**
 * This implementation is thread safe. If the application always create an
 * instance, this one can be used.
 * 
 * @author Xi Chen
 *
 */
class Singleton {
    
    // JVM create the instance when the class is loaded. It guarantees thread safety
    private static Singleton instance = new Singleton();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * This implementation is thread safe, but not efficient as synchronization is
 * expensive
 * 
 * @author Xi Chen
 *
 */
class Singleton {
    private static Singleton instance;
    
    private Singleton() {}
    
    /*
     * "synchronized" key word forces every thread to wait its turn before
     * it can enter the method 
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            return new Singleton();
        }
        return instance;
    }
}

/**
 * This implementation is not thread safe
 * 
 * @author Xi Chen
 *
 */
class Singleton1 {
    private static Singleton1 instance;
    
    private Singleton1() {}
    
    public static Singleton1 getInstance() {
        if (instance == null) {
            return new Singleton1();
        }
        return instance;
    }
}
