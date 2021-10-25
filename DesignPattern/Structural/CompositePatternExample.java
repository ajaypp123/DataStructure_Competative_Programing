

import java.util.*;

interface Account {
    public int getBalance();
}

// Leaf node
class DepositAccount implements Account {

    int balance;
    String accNo;

    DepositAccount(String acc, int b) {
        this.balance = b;
        this.accNo = acc;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

// Leaf Node
class SavingAccount implements Account {

    int balance;
    String accNo;

    SavingAccount(String acc, int b) {
        this.balance = b;
        this.accNo = acc;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

// Composite Node
class CompositeAccount implements Account {

    List<Account> acc;

    CompositeAccount() {
        this.acc = new ArrayList<>();
    }

    public CompositeAccount addAccount(Account a) {
        acc.add(a);
        return this;
    }

    @Override
    public int getBalance() {
        int balance = 0;
        for(Account a: acc) {
            balance += a.getBalance();
        }
        return balance;
    }
}

public class CompositePatternExample {
    public static void main(String[] args) {
        Account person1_dacc = new DepositAccount("DA001", 100);
        Account person2_dacc = new DepositAccount("DA001", 200);

        Account person1_sacc = new SavingAccount("SA001", 100);

        Account person1 = new CompositeAccount();
        ((CompositeAccount)person1).addAccount(person1_dacc).addAccount(person1_sacc);

        Account person2 = new CompositeAccount();
        ((CompositeAccount)person2).addAccount(person2_dacc);

        System.out.println(person1.getBalance());
        System.out.println(person2.getBalance());
    }
}
