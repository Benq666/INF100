package sx3;

/**
 * An address of some place.
 *
 * @author Andrey Belinskiy
 *
 */
public class Address {
    private String street;
    private int streetNumber;
    private int postalCode;
    private String town;
    private String country;


    public Address(String strt, int strtNmbr,
                   int pstlCd, String twn, String cntry) {
        street = strt;
        streetNumber = strtNmbr;
        postalCode = pstlCd;
        town = twn;
        country = cntry;
    }

    public String toString () {
        return String.format("%s %d%n%d, %s%n%s",
                street, streetNumber,
                postalCode, town,
                country);
    }
}
