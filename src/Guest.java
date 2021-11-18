import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.Date;

public class Guest extends PersonalInfo implements Serializable {
    static final long serialVersionUID = 44L;
    private String address;
    private int numberOfGuests;
    private Date startDate;
    private Date endDate;

    public String getAddress() {return address;}
    public int getNumberOfGuests() {return numberOfGuests;}
    public Date getStartDate() {return startDate;}
    public Date getEndDate() {return endDate;}

    public void setAddress(String address) {this.address = address;}
    public void setNumberOfGuests(int numberOfGuests) {this.numberOfGuests = numberOfGuests;}
    public void setStartDate(Date startDate) {this.startDate = startDate;}
    public void setEndDate(Date endDate) {this.endDate = endDate;}

    public Guest () {}

    public Guest (String firstName, String lastName, int phoneNr, String address, int numberOfGuests, Date startDate, Date endDate) {
        super(firstName,lastName,phoneNr);
        this.address = address;
        this.numberOfGuests = numberOfGuests;
        this.startDate = startDate;
        this.endDate = endDate;

    }


}
