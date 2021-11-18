import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Hotel implements Serializable {
    static final long serialVersionUID = 45L;

    private  ArrayList<Room> availableRooms = new ArrayList<>();
    private  ArrayList<Room> bookedRooms = new ArrayList<>();
    private ArrayList<Employee> staff = new ArrayList<>();
    private ArrayList<Employee> staffOnDuty= new ArrayList<>();

    public ArrayList<Employee> getStaff() {return staff;}
    public ArrayList<Room> getAvailableRooms() {return availableRooms;}

    public void addEmployee(Employee employee){staff.add(employee);}
    public void addRoom(Room room){bookedRooms.add(room);}
    public void addAvailableRoom(Room room){availableRooms.add(room);}

    public void printEmployees() {
        System.out.println("Current employees are: ");
        for (int i = 0; i < staff.size(); i++) {
            System.out.println((i + 1) + " "+ getStaff().get(i).getTitle() +": "+  getStaff().get(i).getFirstName() +" "+ getStaff().get(i).getLastName());
        }
    }

    public  void printAvailableRooms() {
        System.out.println("Current available Rooms are: ");
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: "+"Floor: "+ getAvailableRooms().get(i).getFloorNr() +" Room Number: "+ getAvailableRooms().get(i).getRoomNr()
                    +" Type of room:  "+  getAvailableRooms().get(i).getRoomKind() +" Price: "+ getAvailableRooms().get(i).getPricePerNight());
        }
    }
    public  void printBookedRooms() {
        System.out.println("Current booked Rooms are: ");
        for (int i = 0; i < bookedRooms.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: "+"Floor: "+ getAvailableRooms().get(i).getFloorNr() +" Room Number: "+ getAvailableRooms().get(i).getRoomNr()
                    +" Type of room:  "+  getAvailableRooms().get(i).getRoomKind() +" Price: "+ getAvailableRooms().get(i).getPricePerNight());
        }
    }

    public void newBooking (Scanner inputString, Scanner inputInt) {

        try {

            String tempString;
            int tempInt;
            SimpleDateFormat tempDate = new SimpleDateFormat("dd-MM-yyyy");
            Room foundRoom= null;
            System.out.println("What room would you like?");

            boolean quit=false;
            do {
               System.out.println("Press [0] to go back to main menu");
               printAvailableRooms();
               int roomChoice =inputInt.nextInt();

               switch (roomChoice){
                    case 0:
                        System.out.println("Good bye (:");
                        quit=true;
                        break;
                   case 1:
                       foundRoom=availableRooms.get(0);
                       quit=true;
                       break;
                   case 2:
                       foundRoom=availableRooms.get(1);
                       quit=true;
                       break;
                   case 3:
                       foundRoom=availableRooms.get(2);
                       quit=true;
                       break;
                   case 4:
                       foundRoom=availableRooms.get(3);
                       quit=true;
                       break;
                   case 5:
                       foundRoom=availableRooms.get(4);
                       quit=true;
                       break;
                   case 6:
                       foundRoom=availableRooms.get(5);
                       quit=true;
                       break;
                }
            }while (quit==false);

            Constructor<Guest> constructor
                    = Guest.class.getDeclaredConstructor();

            Guest r = constructor.newInstance();

            System.out.println("First name ");
            tempString = inputString.nextLine();
            r.setFirstName(tempString);

            System.out.println("Last name ");
            tempString = inputString.nextLine();
            r.setLastName(tempString);

            System.out.println("Phone number ");
            tempInt = inputInt.nextInt();
            r.setPhoneNr(tempInt);

            System.out.println("Address ");
            tempString = inputString.nextLine();
            r.setAddress(tempString);

            System.out.println("Number og guests ");
            tempInt = inputInt.nextInt();
            r.setNumberOfGuests(tempInt);

            System.out.println("Start date dd-mm-yyyy");
            tempString = inputString.nextLine();
            Date date = tempDate.parse(tempString);
            r.setStartDate(date);

            System.out.println("End date dd-mm-yyyy");
            tempString = inputString.nextLine();
            date = tempDate.parse(tempString);
            r.setEndDate(date);

            foundRoom.setGuestInRoom(r);
            availableRooms.remove(foundRoom);
            bookedRooms.add(foundRoom);
        }
        catch (Exception e) {

            // Display the exception on console
            // using printStackTrace() method
            e.printStackTrace();
        }
    }
}
