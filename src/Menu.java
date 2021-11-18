import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
    private static ArrayList<MenuItem> mainMenu = new ArrayList<>();

    static String mainMenuHeader = "===== M A I N   M E N U========================================================================================================================================================================================================================================\n";
    static String errorMsg = "You did not enter a valid menu option, try again";
    static String staticMenuOption = "Press [0] and then [Enter] to exit/go back to former menu";
    static String hotelPlaza = " __    __    ______   .___________. _______  __         .______    __          ___      ________      ___      \n" +
            "|  |  |  |  /  __  \\  |           ||   ____||  |        |   _  \\  |  |        /   \\    |       /     /   \\     \n" +
            "|  |__|  | |  |  |  | `---|  |----`|  |__   |  |        |  |_)  | |  |       /  ^  \\   `---/  /     /  ^  \\    \n" +
            "|   __   | |  |  |  |     |  |     |   __|  |  |        |   ___/  |  |      /  /_\\  \\     /  /     /  /_\\  \\   \n" +
            "|  |  |  | |  `--'  |     |  |     |  |____ |  `----.   |  |      |  `----./  _____  \\   /  /----./  _____  \\  \n" +
            "|__|  |__|  \\______/      |__|     |_______||_______|   | _|      |_______/__/     \\__\\ /________/__/     \\__\\ \n" +
            "                                                                                                               ";




    // For loop to display menu items from arraylist, used in methods below

    public static void displayMenu(ArrayList<MenuItem> items, String header, String staticMenuOption, String hotelPlaza){
        // Display Menu
        System.out.println(hotelPlaza);
        System.out.println(header);
        System.out.println("Choose an option from the menu:\n ");
        for (int i = 0; i < items.size(); i++){
            System.out.println("Press " + "["+ (i+1) +"]" + " and then [Enter] to " + items.get(i).getName());
        }
        System.out.println(staticMenuOption);
        System.out.println("\n==================================================================================================================================================================================================================================");
    }

    public static void men(){
        mainMenu.add(new MenuItem("Book a Room"));
        mainMenu.add(new MenuItem("Show booked Rooms"));
        mainMenu.add(new MenuItem("Show Available Rooms"));
        mainMenu.add(new MenuItem("Show Working schedule"));
        mainMenu.add(new MenuItem("Show revenue"));
        //return mainMenu;
    }

    // Method to get user choice from main Menu
    public static int makeMainMenuChoice (){
        int num = -1;
        String strInput;
        boolean valid = false;
        int low = 0;
        int high = mainMenu.size();

        //Keep looping until valid input
        while(valid == false){
            // prompt user
            displayMenu(mainMenu, mainMenuHeader, staticMenuOption, hotelPlaza);
            System.out.print("Enter here: ");
            //Grab input from keyboard
            Scanner input = new Scanner(System.in);
            strInput = input.next();
            //try to convert String to int
            try {
                num = Integer.parseInt(strInput);
                if (num >= low && num <= high){
                    valid = true;
                }
                else {
                    // keeps looping
                    //System.out.println(errorMsg);
                }
            }
            catch (NumberFormatException e){
                //System.out.println(errorMsg);
            }
        }
        return num;
    }

    /*
    public static void executeMainMenuChoice(int choice){

        switch (choice){

            case 0:
                System.out.println("Good bye (:");
                break;
            case 1:
                // Book a room
                Hotel.newBooking();
                break;
            case 2:
                // Show booked rooms
                Hotel.printAvailableRooms();
                break;
            case 3:
                // Show available rooms
                System.out.println("Show available rooms");
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

    }
    */




}
