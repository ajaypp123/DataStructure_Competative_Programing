
interface Mediator {
    public void informUser(String user, String msg);
}

class User {

    static Mediator m = new ChatRoom();
    String name;

    User(String name) {
        this.name = name;
    }

    public static void sendMessage(String user, String msg) {
        System.out.println("Sending: "+ msg);
        m.informUser(user, msg);
    }

    public void receiveMessage(String msg) {
        System.out.println("Received: " + msg);
    }

}

class ChatRoom implements Mediator {

    @Override
    public void informUser(String user, String msg) {
        // hashmap can be used to keep track
        System.out.println("[" + user + "]: " + msg);
        User u = new User(user);
        u.receiveMessage(msg);
    }
}

public class MediatorPatternExample {
    public static void main(String[] args) {
        User.sendMessage("B", "Hi");
        User.sendMessage("A", "Hi");
    }
}
