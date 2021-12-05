import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Guest extends PersonalInfo implements Serializable {
    static final long serialVersionUID = 44L;
    private String address;
    private int zipCode;
    private int numberOfGuests;
    private LocalDate startDate;
    private LocalDate endDate;

    public String getAddress() {return address;}
    public int getZipCode() {return zipCode;}
    public int getNumberOfGuests() {return numberOfGuests;}
    public LocalDate getEndDate() {return endDate;}
    public LocalDate getStartDate() {return startDate;}

    public void setAddress(String address) {this.address = address;}
    public void setZipCode(int zipCode) {this.zipCode = zipCode;}
    public void setNumberOfGuests(int numberOfGuests) {this.numberOfGuests = numberOfGuests;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}


    public Guest () {}

    public Guest (String firstName, String lastName, Long phoneNr, String address, int numberOfGuests, LocalDate startDate, LocalDate endDate) {
        super(firstName,lastName,phoneNr);
        this.address = address;
        this.numberOfGuests = numberOfGuests;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public static LocalDate dateValidation(String date) {

        try {
            LocalDate convertedDate;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
            convertedDate = LocalDate.parse(date,formatter);
            return convertedDate;

        } catch (DateTimeParseException e) {
            System.out.println("Convert failed");
            return null;
        }
    }

    public boolean checkZipCode (String input){
        if (input.length()==4 && isNumeric(input)) {
            int temp;
            temp = Integer.parseInt(input);
            zipCode = temp;
            return false;
        }
        System.out.println("Invalid Zip");
        System.out.println("The number has to be 4 digits");
        return true;
    }

    public Long daysBetween() {
        long diff;
        diff = ChronoUnit.DAYS.between(startDate, endDate);
        return diff;
    }

    @Override
    public String toString() {
        return  "Name: " + firstName + " " + lastName +
                "\nAddress: " + address + " " + zipCode +
                "\nPhone number: " + phoneNr +
                "\n " + numberOfGuests + " people, " +
                "staying for " + daysBetween() + " nights" +
                "\narriving the " + startDate +
                " and leaving the " + endDate;

    }
}