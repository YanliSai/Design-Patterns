package singleton;

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

/**
 * This implementation is thread safe, but not efficient as synchronization is
 * expensive
 * 
 * @author Xi Chen
 *
 */
class Singleton2 {
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

/**
 * This implementation is thread safe. If the application always create an
 * instance, this one can be used.
 * 
 * @author Xi Chen
 *
 */
class Singleton3 {
    
    // JVM create the instance when the class is loaded. It guarantees thread safety
    private static Singleton3 instance = new Singleton3();
    
    private Singleton3() {}
    
    public static Singleton3 getInstance() {
        return instance;
    }
}

/**
 * "double-checked locking". Check if an instance is created. If not, we
 * synchronize.
 * 
 * @author Xi Chen
 *
 */
class Singleton4 {
    
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
