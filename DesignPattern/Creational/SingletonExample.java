
class Singleton {
    private static Singleton instance = null;
    // private constructor
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }
}

public class SingletonExample {
    Singleton s = Singleton.getInstance();
}
