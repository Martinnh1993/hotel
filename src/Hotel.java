import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel implements Serializable {
    static final long serialVersionUID = 45L;

    private final ArrayList<Room> availableRooms = new ArrayList<>();
    private final ArrayList<Room> allRooms = new ArrayList<>();
    private final ArrayList<Room> bookedRooms = new ArrayList<>();
    private final ArrayList<Employee> staff = new ArrayList<>();
    private final ArrayList<Revenue> revenues = new ArrayList<>();

    public void addEmployee(Employee employee) {staff.add(employee);}
    public void addBookedRoom(Room room) {bookedRooms.add(room);}
    public void addAvailableRoom(Room room) {availableRooms.add(room);}
    public void addAllRooms(Room room) {allRooms.add(room);}
    public void addRevenue (Revenue revenue) {revenues.add(revenue);}

    public void printEmployees() {
        System.out.println(Menu.staffMenuHeader);
        for (int i = 0; i < staff.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: " + "Employee: " + staff.get(i).getFirstName() + " " + staff.get(i).getLastName() + " Phone nr:  " + staff.get(i).getPhoneNr()
                    + " Title: " + staff.get(i).getTitle() + " Salary: " + staff.get(i).getSalary() + "kr");
            System.out.println(Menu.line);
        }
    }

    public void printAllRooms() {
        System.out.println(Menu.allRoomHeader);
        for (int i = 0; i < allRooms.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: " + "Floor: " + allRooms.get(i).getFloorNr() + " Room Number: " + allRooms.get(i).getRoomNr()
                    + " Type of room:  " + allRooms.get(i).getRoomKind() + " Price: " + allRooms.get(i).getPricePerNight() + "kr");
            System.out.println(Menu.line);
        }
    }

    public  void printAvailableRooms() {
        System.out.println(Menu.availableRoomHeader);
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: " + "Floor: " + availableRooms.get(i).getFloorNr() + " Room Number: " + availableRooms.get(i).getRoomNr()
                    + " Type of room:  " + availableRooms.get(i).getRoomKind() + " Price: " + availableRooms.get(i).getPricePerNight() + "kr");
            System.out.println(Menu.line);
        }
    }

    public void printBookedRooms() {
        System.out.println(Menu.bookedRoomHeader);
        for (int i = 0; i < bookedRooms.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: " + "Floor: " + bookedRooms.get(i).getFloorNr() + " Room Number: " + bookedRooms.get(i).getRoomNr()
                    + " Type of room:  " + bookedRooms.get(i).getRoomKind() + " Price: " + bookedRooms.get(i).getPricePerNight());
            System.out.println(bookedRooms.get(i).getGuestInRoom().toString());
            System.out.println(Menu.line);
        }
    }

    public void printCheckout() {
        System.out.println(Menu.checkoutHeader);
        for (int i = 0; i < bookedRooms.size(); i++) {
            System.out.println("Press [" + (i + 1) + "] to select: " + "Floor: " + bookedRooms.get(i).getFloorNr() + " Room Number: " + bookedRooms.get(i).getRoomNr()
                    + " Type of room:  " + bookedRooms.get(i).getRoomKind() + " Price: " + bookedRooms.get(i).getPricePerNight());
            System.out.println(bookedRooms.get(i).getGuestInRoom().toString());
            System.out.println(Menu.line);
        }
    }

    public void printRevenue() {
        System.out.println(Menu.revenueHeader);
        for (int i = 0; i < revenues.size(); i++) {
            System.out.println(revenues.get(i));
            System.out.println(Menu.line);
        }
    }


    public void newBooking(Scanner inputString, Scanner inputInt) {

        try {
            String tempString;
            int tempInt;
            LocalDate tempDate;
            Room foundRoom;
            int roomChoice;

            System.out.println("What room would you like?");

            do {
                printAvailableRooms();
                System.out.println(Menu.back);
                tempString = inputString.next();
                tempInt = PersonalInfo.convertString(tempString);
                roomChoice = tempInt - 1;

            } while (tempInt == -10);

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
                    tempString = inputString.next();

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
                } while (wrong == true);


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
                } while (newGuest.getStartDate() == null);


                do {
                    System.out.println("End date dd-mm-yyyy ");
                    tempString = inputString.next();
                    tempDate = Guest.dateValidation(tempString);
                    newGuest.setEndDate(tempDate);
                } while (newGuest.getEndDate() == null);

                foundRoom.setGuestInRoom(newGuest);
                availableRooms.remove(foundRoom);
                addBookedRoom(foundRoom);
                System.out.println("Booking complete");

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Going back to main menu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Last catch");
        }
    }

    public void bookedRoomMenu(Scanner inputString, Scanner inputInt) {
        String tempString;
        int tempInt;
        Room foundRoom;
        int roomChoice;
        boolean wrong;
        boolean quit = false;

        do {
            System.out.println("What room would you like?");
            printBookedRooms();
            System.out.println(Menu.back);
            tempString = inputString.next();
            tempInt = PersonalInfo.convertString(tempString);

        } while (tempInt == -10);
        if (tempInt != 0) {
            roomChoice = tempInt - 1;
            foundRoom = bookedRooms.get(roomChoice);
            do {
                System.out.println("Press [1] to change first name");
                System.out.println("Press [2] to change last name");
                System.out.println("Press [3] to change phone number");
                System.out.println("Press [4] to change address");
                System.out.println("press [5] to change zip code");
                System.out.println("Press [6] to change wifi");
                System.out.println("press [7] to change number of guests");
                System.out.println("Press [8] to change end date");
                System.out.println(Menu.back);

                int choice = inputString.nextInt();

                switch (choice) {

                    case 0 -> {
                        System.out.println("Going back to main menu");
                        quit = true;
                    }
                    case 1 -> {
                        // Change first name
                        System.out.println("Current first name is " + foundRoom.getGuestInRoom().getFirstName());
                        System.out.println("What would you like to change it to? ");
                        tempString = inputString.next();
                        foundRoom.getGuestInRoom().setFirstName(tempString);
                        System.out.println("First name changed to " + foundRoom.getGuestInRoom().getFirstName());
                    }
                    case 2 -> {
                        // Change last name
                        System.out.println("Current Last name is " + foundRoom.getGuestInRoom().getLastName());
                        System.out.println("What would you like to change it to? ");
                        tempString = inputString.next();
                        foundRoom.getGuestInRoom().setLastName(tempString);
                        System.out.println("Last name changed to " + foundRoom.getGuestInRoom().getLastName());

                    }
                    case 3 -> {
                        // Change phone Nr
                        System.out.println("Current phone Nr is " + foundRoom.getGuestInRoom().getPhoneNr());
                        System.out.println("What would you like to change it to? ");
                        do {
                            tempString = inputString.next();
                            wrong = foundRoom.getGuestInRoom().checkNr(tempString);
                            foundRoom.getGuestInRoom().setPhoneNr(Long.valueOf(tempString));
                        } while (wrong);
                        System.out.println("Phone Nr changed to " + foundRoom.getGuestInRoom().getPhoneNr());

                    }
                    case 4 -> {
                        // Change address
                        System.out.println("Current address is " + foundRoom.getGuestInRoom().getAddress());
                        System.out.println("What would you like to change it to? ");
                        tempString = inputString.nextLine();
                        foundRoom.getGuestInRoom().setAddress(tempString);
                        System.out.println("Address changed to " + foundRoom.getGuestInRoom().getAddress());
                    }
                    case 5 -> {
                        // Change zip code
                        System.out.println("Current zip code is " + foundRoom.getGuestInRoom().getZipCode());
                        System.out.println("What would you like to change it to? ");
                        do {
                            tempString = inputString.next();
                            wrong = foundRoom.getGuestInRoom().checkZipCode(tempString);
                            foundRoom.getGuestInRoom().setZipCode(PersonalInfo.convertString(tempString));
                        } while (wrong);
                        System.out.println("Zip code changed to " + foundRoom.getGuestInRoom().getZipCode());
                    }
                    case 6 -> {
                        //Change Wi-Fi
                        System.out.println("Room has Wi-Fi " + foundRoom.hasWifiAccess());
                        System.out.println("Would you like to get Wi-Fi? ");
                        tempString = inputString.next();
                        if (tempString.equalsIgnoreCase("yes")) {
                            foundRoom.setWifiAccess(true);
                            System.out.println("Wi-Fi enabled");
                        } else if (tempString.equalsIgnoreCase("no")) {
                            foundRoom.setWifiAccess(false);
                            System.out.println("Wi-Fi disabled");
                        } else {
                            System.out.println("No change");
                        }
                    }
                    case 7 -> {
                        //Change number of guests
                        System.out.println("Current phone Nr is " + foundRoom.getGuestInRoom().getNumberOfGuests());
                        System.out.println("What would you like to change it to? ");
                        do {
                            tempString = inputString.next();
                            tempInt = PersonalInfo.convertString(tempString);

                            if (tempInt > 0 && tempInt <= bookedRooms.get(roomChoice).getCapacity()) {
                                foundRoom.getGuestInRoom().setNumberOfGuests(tempInt);
                            } else {
                                System.out.println("Too many people for this room");
                                System.out.println("The room have space " + bookedRooms.get(roomChoice).getCapacity());
                                foundRoom.getGuestInRoom().setNumberOfGuests(0);
                            }
                        } while (foundRoom.getGuestInRoom().getNumberOfGuests() == 0);
                        System.out.println("Number of guests changed to " + foundRoom.getGuestInRoom().getNumberOfGuests());
                    }
                    case 8 -> {
                        // Change end date
                        System.out.println("Current end date is " + foundRoom.getGuestInRoom().getEndDate());
                        System.out.println("Would you like to extend or shorten the stay? ");
                        tempString = inputString.next();
                        if (tempString.equalsIgnoreCase("extend")) {
                            System.out.println("How many days would you like to extend with? ");
                            tempInt = inputInt.nextInt();
                            foundRoom.getGuestInRoom().setEndDate(foundRoom.getGuestInRoom().getEndDate().plusDays(tempInt));
                            System.out.println("end date changed to " + foundRoom.getGuestInRoom().getEndDate());
                        } else if (tempString.equalsIgnoreCase("shorten")) {
                            System.out.println("How many days would you like to shorten with? ");
                            tempInt = inputInt.nextInt();
                            foundRoom.getGuestInRoom().setEndDate(foundRoom.getGuestInRoom().getEndDate().minusDays(tempInt));
                            System.out.println("end date changed to " + foundRoom.getGuestInRoom().getEndDate());
                        } else {
                            System.out.println("No change");
                        }
                    }

                    default -> {
                        System.out.println("Invalid input");
                        quit = false;
                    }
                }
            } while (quit == false);
        } else {
            System.out.println("Going back to main menu");
        }
    }

    public void checkOut (Scanner inputString) {
        String tempString;
        int tempInt;
        Room foundRoom;
        int roomChoice;


        do {
            System.out.println("Current occupied rooms are");
            printCheckout();
            System.out.println(Menu.back);

            tempString = inputString.next();
            tempInt = PersonalInfo.convertString(tempString);

        } while (tempInt == -10);
        if (tempInt != 0) {
            roomChoice = tempInt - 1;
            foundRoom = bookedRooms.get(roomChoice);
            System.out.println("Name: " + foundRoom.getGuestInRoom().getFirstName() + " " + foundRoom.getGuestInRoom().getLastName());
            System.out.println("Phone number: " + foundRoom.getGuestInRoom().getPhoneNr());
            System.out.println("Address: " + foundRoom.getGuestInRoom().getAddress() + " " + foundRoom.getGuestInRoom().getZipCode());
            System.out.println("Number of guests: " + foundRoom.getGuestInRoom().getNumberOfGuests());
            System.out.println("Nights: " + foundRoom.getGuestInRoom().daysBetween());
            if (foundRoom.hasWifiAccess()) {
                System.out.println("Additional charges: Wi-Fi");
            } else {
                System.out.println("Additional charges: No");
            }
            System.out.println("\nTotal price:");
            System.out.println(foundRoom.getGuestInRoom().daysBetween() + " x " + foundRoom.getPricePerNight() + "kr");
            if (foundRoom.hasWifiAccess()) {
                System.out.println(foundRoom.getGuestInRoom().daysBetween() + " x 50kr");
                double total = (foundRoom.getPricePerNight() * foundRoom.getGuestInRoom().daysBetween()) + (50 * foundRoom.getGuestInRoom().daysBetween());
                System.out.println("Total price: " + total + "kr");
                System.out.println("Pay now y/n");
                tempString = inputString.next();
                if (tempString.equalsIgnoreCase("y")) {
                    System.out.println("Transaction complete");
                    for (int i = 1; i <= 12; i++) {
                        if (foundRoom.getGuestInRoom().month()== i) {
                            double tempRevenue = revenues.get(i-1).getRevenue();
                            int tempGuests = revenues.get(i-1).getGuests();
                            revenues.get(i-1).setRevenue(tempRevenue += total);
                            revenues.get(i-1).setGuests(tempGuests += foundRoom.getGuestInRoom().getNumberOfGuests());
                        }
                    }
                    foundRoom.setGuestInRoom(null);
                    foundRoom.setWifiAccess(false);
                    bookedRooms.remove(foundRoom);
                    availableRooms.add(foundRoom);
                } else {
                    System.out.println("Checkout canceled");
                }
            } else {
                double total = foundRoom.getPricePerNight() * foundRoom.getGuestInRoom().daysBetween();
                System.out.println("Total price: " + total + "kr");
                System.out.println("Pay now y/n");
                tempString = inputString.next();
                if (tempString.equalsIgnoreCase("y")) {
                    System.out.println("Transaction complete");
                    for (int i = 1; i <= 12; i++) {
                        if (foundRoom.getGuestInRoom().month()== i) {
                            double tempRevenue = revenues.get(i-1).getRevenue();
                            int tempGuests = revenues.get(i-1).getGuests();
                            revenues.get(i-1).setRevenue(tempRevenue += total);
                            revenues.get(i-1).setGuests(tempGuests += foundRoom.getGuestInRoom().getNumberOfGuests());
                        }
                    }
                    foundRoom.setGuestInRoom(null);
                    foundRoom.setWifiAccess(false);
                    bookedRooms.remove(foundRoom);
                    availableRooms.add(foundRoom);
                } else {
                    System.out.println("Checkout canceled");
                }
            }
        } else {
            System.out.println("going back to main menu");
        }
    }

    public void employeeMenu(Scanner inputString) {
        String tempString;
        int tempInt;
        Employee foundEmployee;
        int empChoice;
        boolean wrong;
        boolean quit = false;

        do {
            System.out.println("Choose employee");
            printEmployees();
            System.out.println(Menu.back);
            tempString = inputString.next();
            tempInt = PersonalInfo.convertString(tempString);

        } while (tempInt == -10);
        if (tempInt != 0) {
            empChoice = tempInt - 1;
            foundEmployee = staff.get(empChoice);
            do {
                System.out.println("Press [1] to change first name");
                System.out.println("Press [2] to change last name");
                System.out.println("Press [3] to change phone number");
                System.out.println("Press [4] to change title");
                System.out.println("press [5] to change salary");
                System.out.println(Menu.back);

                int choice = inputString.nextInt();

                switch (choice) {

                    case 0 -> {
                        System.out.println("Going back to main menu");
                        quit = true;
                    }
                    case 1 -> {
                        // Change first name
                        System.out.println("Current first name is " + foundEmployee.getFirstName());
                        System.out.println("What would you like to change it to? ");
                        tempString = inputString.next();
                        foundEmployee.setFirstName(tempString);
                        System.out.println("First name changed to " + foundEmployee.getFirstName());
                    }
                    case 2 -> {
                        // Change last name
                        System.out.println("Current Last name is " + foundEmployee.getLastName());
                        System.out.println("What would you like to change it to? ");
                        tempString = inputString.next();
                        foundEmployee.setLastName(tempString);
                        System.out.println("Last name changed to " + foundEmployee.getLastName());

                    }
                    case 3 -> {
                        // Change phone Nr
                        System.out.println("Current phone Nr is " + foundEmployee.getPhoneNr());
                        System.out.println("What would you like to change it to? ");
                        do {
                            tempString = inputString.next();
                            wrong = foundEmployee.checkNr(tempString);
                            foundEmployee.setPhoneNr(Long.valueOf(tempString));
                        } while (wrong);
                        System.out.println("Phone Nr changed to " + foundEmployee.getPhoneNr());

                    }
                    case 4 -> {
                        // Change title
                        System.out.println("Current address is " + foundEmployee.getTitle());
                        System.out.println("What would you like to change it to? ");
                        tempString = inputString.nextLine();
                        foundEmployee.setTittle(tempString);
                        System.out.println("Address changed to " + foundEmployee.getTitle());
                    }
                    case 5 -> {
                        // Change salary
                        System.out.println("Current zip code is " + foundEmployee.getSalary());
                        System.out.println("What would you like to change it to? ");
                        do {
                            tempString = inputString.next();
                            tempInt = PersonalInfo.convertString(tempString);
                            foundEmployee.setSalary(tempInt);
                        } while (tempInt == -10);
                    }

                    default -> {
                        System.out.println("Invalid input");
                        quit = false;
                    }
                }
            } while (quit == false);
        } else {
            System.out.println("Going back to main menu");
        }
    }

    public void changeRoomPrice(Scanner inputString) {
        String tempString;
        boolean valid;
        int roomChoice;

        do {
            System.out.println("What room would you like to change the price on? ");
            printAllRooms();
            System.out.println("Press [0] to go back to main");
            tempString = inputString.next();
            roomChoice = PersonalInfo.convertString(tempString);
            if (roomChoice >= 0 && roomChoice <=6) {
                valid = true;
            } else {
                valid = false;
            }
        } while (valid == false);

            switch (roomChoice) {
                case '1', '2', '3', '4', '5', '6':
                    double newPricePerNight;
                    System.out.print("Enter new Price per night: ");
                    try {
                        tempString = inputString.next();
                        newPricePerNight = Double.parseDouble(tempString);
                        if (newPricePerNight < 0) {
                            Menu.errorMsg = "Error - Price per night has to be a numeric value higher than 0, try again";
                        }
                        if (newPricePerNight > 0) {
                            allRooms.get(roomChoice-1).setPricePerNight(newPricePerNight);
                        }
                    } catch (Exception e) {
                        Menu.errorMsg = "Error - Price per night has to be a numeric value, try again";
                    }
                case '0':
                    // back
            }

    }

    public void revenueStream (Scanner inputString) {
        int run;
        do {
            printRevenue();
            System.out.println(Menu.back);
            run = Integer.parseInt(inputString.next());

        } while (run != 0);
    }
}