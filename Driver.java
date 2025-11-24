// Driver.java
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LibraryStorage storage = new LibraryStorage();    // teammates’ class
        LibraryDisplay display = new LibraryDisplay(storage);

        String choice = "";
        while (!"8".equals(choice)) {
            System.out.println("\n===== Library Inventory =====");
            System.out.println("1. Add item");
            System.out.println("2. Checkout item");
            System.out.println("3. Checkin item");
            System.out.println("4. Print items in storage");
            System.out.println("5. Print checked-out items");
            System.out.println("6. Swap two compartments");
            System.out.println("7. Save and exit");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = in.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.println("[Stub] Add item");
                    // later: collect type and fields, then call storage.addItem(...)
                }
                case "2" -> {
                    System.out.println("[Stub] Checkout item");
                    // later: ask shelf, compartment, borrower, due date, call storage.checkoutItem(...)
                }
                case "3" -> {
                    System.out.println("[Stub] Checkin item");
                    // later: ask shelf, compartment, call storage.checkinItem(...)
                }
                case "4" -> {
                    display.printItemsInStorage();
                    pause(in);
                }
                case "5" -> {
                    display.printCheckedOutItems();
                    pause(in);
                }
                case "6" -> {
                    System.out.println("[Stub] Swap compartments");
                    // later: ask s1,c1,s2,c2 then storage.swapCompartments(...)
                }
                case "7" -> {
                    System.out.println("[Stub] Save to file then exit");
                    // later: LibraryFileIO.saveLibraryData(storage); then break loop
                    break;
                }
                case "8" -> System.out.println("Goodbye.");
                default -> {
                    System.out.println("Invalid choice.");
                    pause(in);
                }
            }
        }
        in.close();
    }

    private static void pause(Scanner in) {
        System.out.print("Press Enter to continue...");
        in.nextLine();
    }
}
