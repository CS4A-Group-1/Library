import java.util.ArrayList;

public class LibraryDisplay {
    
    private LibraryDisplay() {}

    public static void printItemsInStorage(LibraryStorage libraryStorage) {
        System.out.println("\n========================================");
        System.out.println("       ITEMS CURRENTLY IN STORAGE       ");
        System.out.println("========================================");
        
        ArrayList<Shelf> shelves = libraryStorage.getShelves();
        
        for (int shelfIndex = 0; shelfIndex < shelves.size(); shelfIndex++) {
            Shelf currentShelf = shelves.get(shelfIndex);
            Compartment[] compartments = currentShelf.getCompartments();
            
            for (int compartmentIndex = 0; compartmentIndex < compartments.length; compartmentIndex++) {
                Compartment currentCompartment = compartments[compartmentIndex];
                if (currentCompartment != null) {
                    if (currentCompartment.getItem() != null && !currentCompartment.getIsCheckedOut()) {
                        System.out.println("Location: Shelf " + shelfIndex + ", Compartment " + compartmentIndex);
                        System.out.println("Item Details: " + currentCompartment.getItem().toString());
                        System.out.println("----------------------------------------");
                    }
                }
            }
        }
    }

    public static void printCheckedOutItems(LibraryStorage libraryStorage) {
        System.out.println("\n========================================");
        System.out.println("          CHECKED OUT ITEMS             ");
        System.out.println("========================================");
        
        ArrayList<Shelf> shelves = libraryStorage.getShelves();
        
        for (int shelfIndex = 0; shelfIndex < shelves.size(); shelfIndex++) {
            Shelf currentShelf = shelves.get(shelfIndex);
            Compartment[] compartments = currentShelf.getCompartments();
            
            for (int compartmentIndex = 0; compartmentIndex < compartments.length; compartmentIndex++) {
                Compartment currentCompartment = compartments[compartmentIndex];
                if (currentCompartment != null) {
                    if (currentCompartment.getItem() != null && currentCompartment.getIsCheckedOut()) {
                        System.out.println("Item: " + currentCompartment.getItem().toString());
                        System.out.println("   Borrower: " + currentCompartment.getCurrentBorrower());
                        System.out.println("   Due Date: " + currentCompartment.getDueDate());
                        System.out.println("----------------------------------------");
                    }
                }
            }
        }
    }
}
