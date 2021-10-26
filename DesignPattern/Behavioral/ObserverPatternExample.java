
import java.util.*;

interface Observer {
    public void notify(String msg);
}

class AppUser implements Observer {

    @Override
    public void notify(String msg) {
        System.out.println("Notification: " + msg);
    }
}

// observe to this class
interface Subject {
    public void register(Observer ob);
    public void deregister(Observer ob);
}

class DeliverySystem implements Subject{
    String location;
    HashSet<Observer> obList;

    DeliverySystem() {
        obList = new HashSet<>();
    }

    public void updateLocation(String msg) {
        location = msg;
        for(Observer ob: obList) {
            ob.notify(msg);
        }
    }

    @Override
    public void register(Observer ob) {
        obList.add(ob);
    }

    @Override
    public void deregister(Observer ob) {
        obList.remove(ob);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        Observer u1 = new AppUser();
        DeliverySystem ds = new DeliverySystem();

        ds.register(u1);
        ds.updateLocation("Starting location set to X");
        ds.updateLocation("Next location set to P");
        ds.updateLocation("Next location set to Q");
        ds.updateLocation("End location set to Y");
    }
}
