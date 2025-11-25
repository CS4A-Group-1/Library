import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Driver {

    private static void step(String label) {
        System.out.println("\n== " + label);
    }

    public static void main(String[] args) {
        System.out.println("Initializing Library System...");

       String filename = "library_data.dat";
        
        LibraryStorage storage = LibraryFileIO.loadLibraryData(filename);
        if (storage.getShelves().isEmpty()) {
            System.out.println("Starting with empty storage...");
            storage.addShelf(new Shelf());
            storage.addShelf(new Shelf());
            storage.addShelf(new Shelf());
        } else {
            System.out.println("Loading from file...");
        }
        // 2) Create real items
        step("Create items");
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Cillian Murphy");
        cast.add("Robert Downey Jr.");
        cast.add("Emily Blunt");
        Movie oppenheimer = new Movie(
                "Oppenheimer",
                "Biographical thriller film",
                "MOV-2023-OPP",
                "Oppenheimer",
                "Christopher Nolan",
                cast
        );

        Magazine timeJan = new Magazine(
                "Time Magazine",
                "Weekly news magazine",
                "MAG-2024-JAN",
                "Time",
                "January 2024 Issue"
        );

        // 3) Add items
        step("Add items");
        boolean putMovie = storage.addItem(oppenheimer, 0, 0);
        boolean putMag = storage.addItem(timeJan, 0, 1);
        System.out.println("addItem(oppenheimer, 0,0) -> " + putMovie);
        System.out.println("addItem(timeJan, 0,1) -> " + putMag);

        // 4) Get items 
        step("Get items");
        try {
            System.out.println("getItem(0,0) -> " + storage.getCompartment(0, 0).getItem());
            System.out.println("getItem(0,1) -> " + storage.getCompartment(0, 1).getItem());
        } catch (Exception e) {
            System.out.println("Could not get item (might be null or invalid)");
        }

        // 5) Checkout using a Compartment reference 
        step("Checkout by compartment");
        Compartment slot00 = storage.getCompartment( 0, 0);
        if (slot00 != null) { 
            Date due = storage.checkOutItem(slot00, "John Smith");
            boolean checkedOut = (due != null);
            System.out.println("checkOutItem(slot00, John Smith) -> " + checkedOut);
            if (checkedOut) {
                System.out.println("Due date: " + due);
            }
        } else {
            System.out.println("slot00 not found");
        }

        // 6) Show checked-out items 
        step("Display checked-out items");
        LibraryDisplay.printCheckedOutItems(storage);

        // 7) Check in using a Compartment reference 
        step("Check in by compartment");
        Compartment slot00Again = storage.getCompartment(0, 0);
        if (slot00Again != null) {
            boolean checkedIn = storage.checkInItem(slot00Again); 
            System.out.println("checkInItem(slot00) -> " + checkedIn);
        }

        // 8) Show items in storage 
        step("Display items in storage");
        LibraryDisplay.printItemsInStorage(storage);

        // 9) Swap two compartments
        step("Swap items (0,0) <-> (0,1)");
        boolean swapped = storage.swapItems(0, 0, 0, 1);
        System.out.println("swapItems(0,0, 0,1) -> " + swapped);
        LibraryDisplay.printItemsInStorage(storage); 
        
        // Edge Case Testing
        step("Testing Error Handling (Invalid Index)");
        try {
            System.out.println("Attempting to access Shelf 99 (Invalid)...");
            storage.getShelves().get(99); 
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected error: Shelf index out of bounds.");
        }


        // 10) Save
        step("Save to file");
        boolean saved = LibraryFileIO.saveLibraryData(storage, filename);
        System.out.println("saveLibraryData -> " + saved);

        System.out.println("\nDone");
    }
}


