

interface Coffee {
    public int cost();
}

// Base Class
class Espresso implements Coffee {
    @Override
    public int cost() {
        return 100;
    }
}

class DeCafee implements Coffee {
    @Override
    public int cost() {
        return 120;
    }
}

// Decorator
class CofeeAddOn implements Coffee {

    Coffee c;

    CofeeAddOn(Coffee c) {
        this.c = c;
    }

    @Override
    public int cost() {
        return this.c.cost();
    }
}

// Decorator classes
class MilkAddOn extends CofeeAddOn {

    MilkAddOn(Coffee c) {
        super(c);
    }

    @Override
    public int cost() {
        int cost = super.cost();
        return 40+cost;
    }
}

class SoyAddOn extends CofeeAddOn {

    SoyAddOn(Coffee c) {
        super(c);
    }

    @Override
    public int cost() {
        int cost = super.cost();
        return 20+cost;
    }
}


public class DecoratorPatterTest {
    public static void main(String[] args) {
        Coffee c1 = new MilkAddOn(new SoyAddOn(new Espresso()));
        System.out.println(c1.cost());

        Coffee c2 = new MilkAddOn(new SoyAddOn(new DeCafee()));
        System.out.println(c2.cost());
    }
}
