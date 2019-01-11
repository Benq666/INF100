package sx3;

/**
 * A person that represents sender or receiver of the parcel
 *
 * @author Andrey Belinskiy
 *
 */
public class Person {
    private String name;
    private Address address;

    public Person (String n, Address addrss) {
        name = n;
        address = addrss;
    }

    public String toString() {
        return String.format("%s%n%s", name, address);
    }
}
