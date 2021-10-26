
import java.util.*;

// Originator
class Cart {
    List<String> items;

    Cart() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void printData() {
        System.out.println(items.toString());
    }

    public CartMomento getMomento() {
        return new CartMomento(items);
    }

    public void restoreMomento(CartMomento state) {
        this.items = state.getMomento();
    }
}

// Momento store all variable
class CartMomento {
    List<String> items;
    private Object clone;

    CartMomento(List<String> items) {
        clone = ((ArrayList<String>)items).clone();
        this.items = (List<String>)clone;
    }

    public List<String> getMomento() {
        return items;
    }
}

class CartCareTaker {
    Stack<CartMomento> st;

    CartCareTaker() {
        st = new Stack<>();
    }

    public void saveState(CartMomento cm) {
        st.push(cm);
    }

    public CartMomento getLastState() {
        return st.peek();
    }
}

public class MomentoPatternExample {
    public static void main(String[] args) {
        Cart cart = new Cart();
        CartCareTaker ct = new CartCareTaker();

        cart.addItem("I1");
        cart.addItem("I2");
        cart.printData();

        ct.saveState(cart.getMomento());

        cart.addItem("I3");
        cart.printData();

        cart.restoreMomento(ct.getLastState());

        cart.printData();

    }
}
