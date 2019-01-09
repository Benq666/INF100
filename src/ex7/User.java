package ex7;
import java.util.ArrayList;

public class User implements Comparable<User> {
    private String name;
    private ArrayList<User> friends;
    private static ArrayList<User> users = new ArrayList<User>();

    public User (String name) {
        this.name = name;
        this.friends = new ArrayList<User>();
        users.add(this);
    }

    public String toString () {
        String frNames = "";
        for (User u : friends) {
            frNames += u.name + ", ";
        }
        // removing ", " at the end of the string
        frNames = frNames.substring(0, frNames.length() - 2);
        return name + " : {" + frNames + "}";
    }

    public void addFriend (User friend) {
        this.friends.add(friend);
    }

    public static void connect(User user1, User user2) {
        user1.addFriend(user2);
        user2.addFriend(user1);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public int compareTo (User otherUser) {
        return this.friends.size() - otherUser.friends.size();
    }
}
