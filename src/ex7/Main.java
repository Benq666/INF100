package ex7;
import java.util.Collections;

/*
        This program implements basic system
        that stores information about users and their friends.
 */

public class Main {
    public static void main(String[] args) {
        User bob = new User("Bob");
        User alice = new User("Alice");
        User charlie = new User("Charlie");

        User.connect(alice,bob);
        User.connect(alice,charlie);

        Collections.sort(User.getUsers());

        System.out.println(User.getUsers());
    }
}
