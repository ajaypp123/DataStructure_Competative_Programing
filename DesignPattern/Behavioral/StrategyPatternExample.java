
// Fly strategy
interface IDuckFly {
    public void fly();
}

class SimpleFly implements IDuckFly {
    @Override
    public void fly() {

    }
}

class JetFly implements IDuckFly {
    @Override
    public void fly() {

    }
}

// Quack strategy
interface IDuckQuack {
    public void quack();
}

class SimpleQuack implements IDuckQuack {
    @Override
    public void quack() {

    }
}

class SmartQuack implements IDuckQuack {
    @Override
    public void quack() {

    }
}

// Clients
interface Duck {
    public void walk();
}

class CityDuck implements Duck {

    IDuckFly fly;
    IDuckQuack quack;

    CityDuck(IDuckFly fly, IDuckQuack quack) {
        this.fly = fly;
        this.quack = quack;
    }

    @Override
    public void walk() {

    }

}

class WildDuck implements Duck {

    IDuckFly fly;
    IDuckQuack quack;

    WildDuck(IDuckFly fly, IDuckQuack quack) {
        this.fly = fly;
        this.quack = quack;
    }

    @Override
    public void walk() {

    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        Duck cduck = new CityDuck(new SimpleFly(), new SmartQuack());
        Duck wduck = new WildDuck(new JetFly(), new SimpleQuack());
    }
}
