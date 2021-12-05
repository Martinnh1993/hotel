import java.io.Serializable;

public class Revenue implements Serializable {
    static final long serialVersionUID = 48L;

    private String month;
    private double revenue;
    private int guests;

    public Revenue (String month, double revenue, int guests) {
        this.month = month;
        this.revenue = revenue;
        this.guests = guests;
    }

    public String getMonth() {return month;}
    public void setMonth(String month) {this.month = month;}
    public double getRevenue() {return revenue;}

    public void setRevenue(double revenue) {this.revenue = revenue;}
    public int getGuests() {return guests;}
    public void setGuests(int guests) {this.guests = guests;}

    @Override
    public String toString() {
        return "Month: " + month +
                "\nRevenue:" + revenue +
                "\nGuests:" + guests;
    }
}
