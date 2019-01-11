package sx3;

import java.util.UUID;

/**
 * A parcel that needs to be sent.
 *
 * @author Andrey Belinskiy
 *
 */
public class Parcel {
    private Person sender;
    private Person recipient;
    private UUID barcode;

    public Parcel(Person sndr, Person recpent) {
        barcode = UUID.randomUUID();
        sender = sndr;
        recipient = recpent;
    }

    public String toString() {
        return String.format("Barcode: %s%nSender: %s%nRecipient: %s%n",
                barcode, sender, recipient);
    }
}
