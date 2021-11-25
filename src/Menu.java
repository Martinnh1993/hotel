import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu{
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
    public static void displayMenu() {
        System.out.println(hotelPlaza);
        System.out.println(mainMenuHeader);
        System.out.println("1) Book a Room");
        System.out.println("2) Show Booked Rooms");
        System.out.println("3) Check Out");
        System.out.println("4) Update Room Price");
        System.out.println("5) Show Staff");
        System.out.println("6) Show Working Schedule");
        System.out.println("7) Show Revenue");
        System.out.println("0) Exit");

    }
}
