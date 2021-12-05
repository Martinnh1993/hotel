public abstract class Menu{

    static String mainMenuHeader = "===== M A I N   M E N U========================================================================================================================================================================================================================================\n";
    static String errorMsg = "You did not enter a valid menu option, try again";
    static String hotelPlaza = """
             __    __    ______   .___________. _______  __         .______    __          ___      ________      ___     \s
            |  |  |  |  /  __  \\  |           ||   ____||  |        |   _  \\  |  |        /   \\    |       /     /   \\    \s
            |  |__|  | |  |  |  | `---|  |----`|  |__   |  |        |  |_)  | |  |       /  ^  \\   `---/  /     /  ^  \\   \s
            |   __   | |  |  |  |     |  |     |   __|  |  |        |   ___/  |  |      /  /_\\  \\     /  /     /  /_\\  \\  \s
            |  |  |  | |  `--'  |     |  |     |  |____ |  `----.   |  |      |  `----./  _____  \\   /  /----./  _____  \\ \s
            |__|  |__|  \\______/      |__|     |_______||_______|   | _|      |_______/__/     \\__\\ /________/__/     \\__\\\s
                                                                                                                          \s""";

    public static void displayMenu() {
        System.out.println(hotelPlaza);
        System.out.println(mainMenuHeader);
        System.out.println("Press [1] to select: Book a Room");
        System.out.println("Press [2] to select: Show Booked Rooms");
        System.out.println("Press [3] to select: Check Out");
        System.out.println("Press [4] to select: Update Room Price");
        System.out.println("Press [5] to select: Show Staff");
        System.out.println("Press [6] to select: Show Revenue");
        System.out.println("Press [0] to select: Exit");
    }
}
