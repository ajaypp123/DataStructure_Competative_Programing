

interface Logistic {
    public String getType();
}

class AirLogistic implements Logistic {
    @Override
    public String getType() {
        return "Air";
    }
}

class WaterLogistic implements Logistic {
    @Override
    public String getType() {
        return "Water";
    }
}

class DefaultLogistic implements Logistic {
    @Override
    public String getType() {
        return "Default";
    }
}

class LogisticFactory {
    public static Logistic getLogistic(String type) {
        if(type == "air") {
            return new AirLogistic();
        } else if(type == "water") {
            return new WaterLogistic();
        } else {
            return new DefaultLogistic();
        }
    }
}

public class FactoryPatternExample {

    public static void main(String[] args) {
        Logistic l = LogisticFactory.getLogistic("air");
        System.out.println(l.getType());
    }
}
