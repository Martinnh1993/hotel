public abstract class Menu{

    static String mainMenuHeader = "===== M A I N   M E N U ======================================================================================================================================================================================================================================";
    static String staffMenuHeader = "===== E M P L O Y E E  ======================================================================================================================================================================================================================================";
    static String allRoomHeader = "===== R O O M S ===================================================================================================================================================================================================================================";
    static String bookedRoomHeader = "===== B O O K E D   R O O M S ==============================================================================================================================================================================================================================";
    static String availableRoomHeader = "===== A V A I L A B L E   R O O M S =====================================================================================================================================================================================================================";
    static String checkoutHeader = "===== C H E C K O U T ========================================================================================================================================================================================================================================";
    static String revenueHeader = "===== R E V E N U E ===========================================================================================================================================================================================================================================";
    static String line = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
    static String errorMsg = "You did not enter a valid menu option, try again";
    static String back = "Press [0] to select: Back";
    static String hotelPlaza = """
             __    __    ______   .___________. _______  __         .______    __          ___      ________      ___     \s
            |  |  |  |  /  __  \\  |           ||   ____||  |        |   _  \\  |  |        /   \\    |       /     /   \\    \s
            |  |__|  | |  |  |  | `---|  |----`|  |__   |  |        |  |_)  | |  |       /  ^  \\   `---/  /     /  ^  \\   \s
            |   __   | |  |  |  |     |  |     |   __|  |  |        |   ___/  |  |      /  /_\\  \\     /  /     /  /_\\  \\  \s
            |  |  |  | |  `--'  |     |  |     |  |____ |  `----.   |  |      |  `----./  _____  \\   /  /----./  _____  \\ \s
            |__|  |__|  \\______/      |__|     |_______||_______|   | _|      |_______/__/     \\__\\ /________/__/     \\__\\\s
                                                                                                                          \s""";

    public static void displayMenu() {
        System.out.println(mainMenuHeader);
        System.out.println("Press [1] to select: Book a Room");
        System.out.println(line);
        System.out.println("Press [2] to select: Show Booked Rooms");
        System.out.println(line);
        System.out.println("Press [3] to select: Check Out");
        System.out.println(line);
        System.out.println("Press [4] to select: Update Room Price");
        System.out.println(line);
        System.out.println("Press [5] to select: Show Employee");
        System.out.println(line);
        System.out.println("Press [6] to select: Show Revenue");
        System.out.println(line);
        System.out.println("Press [0] to select: Exit");
    }
}
