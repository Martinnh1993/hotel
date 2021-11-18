import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Hotel plaza = new Hotel();
            Scanner inputString = new Scanner(System.in);
            Scanner inputInt = new Scanner(System.in);


            Room single1 = new Room("Single bedroom",false,1300,true,1,1);
            Room single2 = new Room("Single bedroom",false,1350,true,2,1);
            Room double1 = new Room("Double bedroom",false,1450,true,1,2);
            Room double2 = new Room("Double bedroom",false,1500,true,2,2);
            Room suite1 = new Room("Suite",true,2000,true,1,3);
            Room suite2 = new Room("Suite",true,2400,true,2,3);

            plaza.addAvailableRoom(single1);
            plaza.addAvailableRoom(single2);
            plaza.addAvailableRoom(double1);
            plaza.addAvailableRoom(double2);
            plaza.addAvailableRoom(suite1);
            plaza.addAvailableRoom(suite2);

            Employee em1 = new Employee("nayeem","hossain",81913638, "Director",300);
            Employee em2 = new Employee("Emil","Bocadillo",5848654, "Receptionist",150);
            Employee em3 = new Employee("Martin","Niemann Hansen",52404922,"Accountant",250);
            Employee em4 = new Employee("Andrea","Di Claudio",45786123,"Cleaning lady",120);

            plaza.addEmployee(em1);
            plaza.addEmployee(em2);
            plaza.addEmployee(em3);
            plaza.addEmployee(em4);

            Serialization.serialize(plaza, "Database.ser");


           // plaza = Serialization.deSerialize("Database.ser");
            boolean quit=false;
            do {


                Menu.makeMainMenuChoice();

                int choice = inputInt.nextInt();
                switch (choice){

                    case 0:
                        System.out.println("Good bye (:");
                        quit=true;
                        break;
                    case 1:
                        // Book a room
                        plaza.newBooking(inputString,inputInt);
                        Serialization.serialize(plaza,"Database.ser");
                        break;
                    case 2:
                        // Show booked rooms
                        plaza.printBookedRooms();
                        break;
                    case 3:
                        // Show available rooms
                        plaza.printAvailableRooms();
                        break;
                    case 4:
                        // Show working schedule
                        System.out.println("Show working schedule");
                        break;
                    case 5:
                        // Show economy: Budget, revenue, earnings, expenses etc.
                        System.out.println("Show economy: Budget, revenue, earnings, expenses etc.");
                        break;
                    default:
                        // We should never get here because makeMainMenuChoice() makes sure that we only get valid options, but there have to be a default case
                        System.out.println("Invalid input");

                }

            } while (quit==false);
        }
    }
