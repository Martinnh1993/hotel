import java.util.Scanner;
import java.io.*;

public class Main {

        public static void main(String[] args) {
            Hotel plaza = new Hotel();
            Scanner inputString = new Scanner(System.in);
            Scanner inputInt = new Scanner(System.in);


            File file = new File("Database.ser");
            if (file.length() == 0) {
                System.out.println("File is empty");
                Room single1 = new Room("Single bedroom", false, 1300, 1, 1, 2);
                Room single2 = new Room("Single bedroom", false, 1350, 2, 1, 2);
                Room double1 = new Room("Double bedroom", false, 1450, 1, 2, 4);
                Room double2 = new Room("Double bedroom", false, 1500, 2, 2, 4);
                Room suite1 = new Room("Suite", true, 2000, 1, 3, 6);
                Room suite2 = new Room("Suite", true, 2400, 2, 3, 6);

                plaza.addAvailableRoom(single1);
                plaza.addAvailableRoom(single2);
                plaza.addAvailableRoom(double1);
                plaza.addAvailableRoom(double2);
                plaza.addAvailableRoom(suite1);
                plaza.addAvailableRoom(suite2);

                plaza.addAllRooms(single1);
                plaza.addAllRooms(single2);
                plaza.addAllRooms(double1);
                plaza.addAllRooms(double2);
                plaza.addAllRooms(suite1);
                plaza.addAllRooms(suite2);

                Employee em1 = new Employee("Nayeem", "hossain", 81913638L, "Director", 300);
                Employee em2 = new Employee("Emil", "Bocadillo", 5848654L, "Receptionist", 150);
                Employee em3 = new Employee("Martin", "Niemann Hansen", 52404922L, "Accountant", 250);
                Employee em4 = new Employee("Andrea", "Di Claudio", 45786123L, "Cleaning lady", 120);

                plaza.addEmployee(em1);
                plaza.addEmployee(em2);
                plaza.addEmployee(em3);
                plaza.addEmployee(em4);

                Serialization.serialize(plaza, "Database.ser");
                System.out.println("Serialization done");
            } else {
                plaza = Serialization.deSerialize("Database.ser");
            }

            System.out.println(Menu.hotelPlaza);
            boolean quit=false;
            do {
                Menu.displayMenu();

                int choice = inputString.nextInt();

                switch (choice) {
                    case -1 -> {
                        Serialization.clearFile("Database.ser");
                        System.out.println("Serialization file has been cleared");
                        quit = true;
                    }
                    case 0 -> {
                        System.out.println("Good bye (:");
                        quit = true;
                    }
                    case 1 -> {
                        // Book a room
                        plaza.newBooking(inputString, inputInt);
                        Serialization.serialize(plaza, "Database.ser");
                    }
                    case 2 -> {
                        // Show booked rooms
                        plaza.bookedRoomMenu(inputString, inputInt);
                        Serialization.serialize(plaza,"Database.ser");
                    }
                    case 3 -> {
                        // Check out
                        plaza.checkOut(inputString);
                        Serialization.serialize(plaza,"Database.ser");
                    }
                    case 4 -> {
                        // Update room price
                        plaza.changeRoomPrice(inputString);
                        Serialization.serialize(plaza,"Database.ser");
                    }
                    case 5 -> {
                        // Show employees and make changes to it
                        plaza.employeeMenu(inputString);
                        Serialization.serialize(plaza,"Database.ser");
                    }

                    case 6 ->
                        plaza.revenueStream();

                    default ->
                            // We should never get here because makeMainMenuChoice() makes sure that we only get valid options, but there have to be a default case
                            System.out.println("Invalid input");


                }
            } while (quit == false);
        }

    }