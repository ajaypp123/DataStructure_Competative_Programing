
// Context
interface Context {
    public void setState(State state);
    public State getState();
}

// State
interface State {
    public void payOk(Context context);
    public void personEnter(Context context);
    public void payFailed(Context context);
    public void alreadyPaid(Context context);
    public void invalidCard(Context context);
}

// open state
class GateOpenState implements State {
    @Override
    public void payOk(Context context) {
        // keep open
        System.out.println("Keep Open");
    }

    @Override
    public void personEnter(Context context) {
        System.out.println("personEnter, close door");
        context.setState( new GateCloseState());
    }

    @Override
    public void payFailed(Context context) {

    }

    @Override
    public void alreadyPaid(Context context) {

    }

    @Override
    public void invalidCard(Context context) {

    }

}

// close state
class GateCloseState implements State {
    @Override
    public void payOk(Context context) {

    }

    @Override
    public void personEnter(Context context) {

    }

    @Override
    public void payFailed(Context context) {

    }

    @Override
    public void alreadyPaid(Context context) {

    }

    @Override
    public void invalidCard(Context context) {

    }

}

// Concrete Context
class Gate implements Context {
    State state;

    public void initialize() {
        state = new GateCloseState();
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State getState() {
        return state;
    }

    // pay event
    public void payOk() {
        this.state.payOk(this);
    }

    // person enter event
    public void personEnter() {
        this.state.personEnter(this);
    }

    // pay Failed
    public void payFailed() {
        this.state.payFailed(this);
    }

    // already paid
    public void alreadyPaid() {
        this.state.alreadyPaid(this);
    }

    // invalid card
    public void invalidCard() {
        this.state.invalidCard(this);
    }
}

public class StatePatternExample {
    public static void main(String[] args) {
        // Initial Contex
        Gate g = new Gate();
        g.initialize();

        g.payOk();
    }
}
