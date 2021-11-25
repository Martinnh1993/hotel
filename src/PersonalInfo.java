import java.io.Serializable;

public abstract class PersonalInfo implements Serializable {
    static final long serialVersionUID = 42L;

    protected String firstName;
    protected String lastName;
    protected Long phoneNr;

    public PersonalInfo () {}

    public PersonalInfo (String firstName, String lastName, Long phoneNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public Long getPhoneNr() {return phoneNr;}

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setPhoneNr(Long phoneNr) {this.phoneNr = phoneNr;}

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkNr (String input){
        if (input.length()==8 && isNumeric(input)) {
            Long temp;
            temp = Long.valueOf(input);
            phoneNr = temp;
            return false;
        }
        System.out.println("Invalid number");
        System.out.println("The number has to be 8 digits");
        return true;
    }

    public static int convertString (String input) {
        try{
            int number = Integer.parseInt(input);
            return number;
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid input");
            return -10;
        }
    }
}

