import java.io.Serializable;

public class Employee extends PersonalInfo implements Serializable {
    static final long serialVersionUID = 43L;

    private String tittle;
    private double salary;

    public Employee(String firstName, String lastName, int phoneNr, String title, double salary) {
        super(firstName,lastName,phoneNr);
        this.tittle = title;
        this.salary = salary;
    }

    public String getTitle() {
        return tittle;
    }

    public double getSalary() {
        return salary;
    }

    public void changeSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " "+ lastName;
             /*   "\ntittle: " + tittle +
                "\nphoneNr: " + phoneNr +
                "\nsalary: " + salary;
*/
    }
}

