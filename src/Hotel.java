import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel implements Serializable {
    static final long serialVersionUID = 45L;

    private ArrayList<Room> availableRooms = new ArrayList<>();
    private ArrayList<Room> allRooms = new ArrayList<>();
    private ArrayList<Room> bookedRooms = new ArrayList<>();
    private ArrayList<Employee> staff = new ArrayList<>();
    private ArrayList<Employee> staffOnDuty = new ArrayList<>();

    public void setBookedRooms(ArrayList<Room> bookedRooms) {this.bookedRooms = bookedRooms;}

    public ArrayList<Employee> getStaff() {return staff;}

    public ArrayList<Room> getBookedRooms() {return bookedRooms;}
    public ArrayList<Room> getAvailableRooms() {return availableRooms;}

    public void addEmployee(Employee employee) {staff.add(employee);}
    public void addBookedRoom(Room room) {bookedRooms.add(room);}
    public void addAvailableRoom(Room room) {availableRooms.add(room);}
    public void addAllRooms (Room room) {allRooms.add(room);}

    public void printEmployees() {
        System.out.println("Current employees are: ");
        for (int i = 0; i < staff.size(); i++) {
            System.out.println((i + 1) + " " + getStaff().get(i).getTitle() + ": " + getStaff().get(i).getFirstName() + " " + getStaff().get(i).getLastName());
        }
    }

    public void printAvailableRooms() {
        System.out.println("Current available Rooms are: ");
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: " + "Floor: " + getAvailableRooms().get(i).getFloorNr() + " Room Number: " + getAvailableRooms().get(i).getRoomNr()
                    + " Type of room:  " + getAvailableRooms().get(i).getRoomKind() + " Price: " + getAvailableRooms().get(i).getPricePerNight());
        }
    }

    public void printBookedRooms() {

        System.out.println("Current booked Rooms are: ");
        for (int i = 0; i < bookedRooms.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: " + "Floor: " + getBookedRooms().get(i).getFloorNr() + " Room Number: " + getBookedRooms().get(i).getRoomNr()
                    + " Type of room:  " + getBookedRooms().get(i).getRoomKind() + " Price: " + getBookedRooms().get(i).getPricePerNight());
            System.out.println(bookedRooms.get(i).getGuestInRoom().toString());
        }
    }

    public void bookedRoomMenu (Scanner inputString) {
        String tempString;
        int tempInt = -10;
        LocalDate tempDate;
        Room foundRoom = null;
        int roomChoice;
        int menuChoice;

        System.out.println("What room would you like?");

        do {
            printBookedRooms();
            System.out.println("Press [0] to go back to main");
            tempString = inputString.next();
            tempInt = PersonalInfo.convertString(tempString);
            roomChoice = tempInt-1;

        }while (tempInt == -10);

        do {
            tempString = inputString.next();
            tempInt = PersonalInfo.convertString(tempString);
            menuChoice = tempInt;

        }while (tempInt == -10);

    switch (menuChoice) {
        case 0:
            System.out.println("0");
    }
    }


    public void newBooking(Scanner inputString, Scanner inputInt) {

        try {
            String tempString;
            int tempInt = -10;
            LocalDate tempDate;
            Room foundRoom = null;
            int roomChoice;

            System.out.println("What room would you like?");

            do {
                 printAvailableRooms();
                 System.out.println("Press [0] to go back to main");
                 tempString = inputString.next();
                 tempInt = PersonalInfo.convertString(tempString);
                 roomChoice = tempInt-1;

            }while (tempInt == -10);

            try {
                foundRoom = availableRooms.get(roomChoice);
                Constructor<Guest> constructor
                        = Guest.class.getDeclaredConstructor();

                Guest newGuest = constructor.newInstance();

                do {
                        System.out.println("Number og guests ");
                        tempString = inputString.next();
                        tempInt = PersonalInfo.convertString(tempString);
                        newGuest.setNumberOfGuests(tempInt);
                        if (tempInt > 0 && tempInt <= availableRooms.get(roomChoice).getCapacity()) {
                            newGuest.setNumberOfGuests(tempInt);
                        } else {
                            System.out.println("Too many people for this room");
                            System.out.println("The room have space " + availableRooms.get(roomChoice).getCapacity());
                            newGuest.setNumberOfGuests(0);
                        }
                } while (newGuest.getNumberOfGuests() == 0);

                System.out.println("First name ");
                tempString = inputString.next();
                newGuest.setFirstName(tempString);
                boolean wrong;

                do {
                System.out.println("Middle name y/n");
                tempString =inputString.next();

                if (tempString.equalsIgnoreCase("y")) {
                    System.out.println("Middle name ");
                    tempString = inputString.next();

                    System.out.println("Last name ");
                    String tempString2 = inputString.next();

                    String join = tempString + " " + tempString2;
                    newGuest.setLastName(join);
                    wrong = false;
                } else if (tempString.equalsIgnoreCase("n")) {
                    System.out.println("Last name ");
                    tempString = inputString.next();
                    newGuest.setLastName(tempString);
                    wrong = false;
                } else {
                    System.out.println("Invalid input");
                    wrong = true;
                }
                } while (wrong);


                do {
                    System.out.println("Phone number ");
                    tempString = inputInt.next();
                    wrong = newGuest.checkNr(tempString);
                    newGuest.setPhoneNr(Long.valueOf(tempString));
                } while (wrong);

                System.out.println("Address ");
                tempString = inputString.next();

                System.out.println("house number ");
                String tempString2 = inputString.next();
                String join = (tempString + " " + tempString2);
                newGuest.setAddress(join);

                do {
                    System.out.println("Zip code ");
                    tempString = inputInt.next();
                    wrong = newGuest.checkZipCode(tempString);
                    newGuest.setZipCode(PersonalInfo.convertString(tempString));
                } while (wrong);

                do {
                    System.out.println("Start date dd-mm-yyyy ");
                    tempString = inputString.next();
                    tempDate = Guest.dateValidation(tempString);
                    newGuest.setStartDate(tempDate);
                } while (tempDate == null);


                do {
                    tempString = "";
                    System.out.println("End date dd-mm-yyyy ");
                    tempString = inputString.next();
                    tempDate = Guest.dateValidation(tempString);
                    newGuest.setEndDate(tempDate);
                } while (tempDate == null);

                foundRoom.setGuestInRoom(newGuest);
                availableRooms.remove(foundRoom);
                bookedRooms.add(foundRoom);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Going back to main menu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Last catch");
        }
    }

    public static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
