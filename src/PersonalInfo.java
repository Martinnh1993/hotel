import java.io.Serializable;

public abstract class PersonalInfo implements Serializable {
    static final long serialVersionUID = 42L;

    protected String firstName;
    protected String lastName;
    protected int phoneNr;

    public PersonalInfo () {}

    public PersonalInfo (String firstName, String lastName, int phoneNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getPhoneNr() {return phoneNr;}

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPhoneNr(int phoneNr) {this.phoneNr = phoneNr;}
}

