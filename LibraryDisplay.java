import java.util.ArrayList;

public class LibraryDisplay {
    private final LibraryStorage libraryStorage;

    public LibraryDisplay(LibraryStorage libraryStorage) {
        this.libraryStorage = libraryStorage;
    }

    public void printItemsInStorage() {
        System.out.println("\n========================================");
        System.out.println("       ITEMS CURRENTLY IN STORAGE       ");
        System.out.println("========================================");
        
        ArrayList<Shelf> shelves = libraryStorage.getShelves();
        
        // Use full variable names for descriptive loops
        for (int shelfIndex = 0; shelfIndex < shelves.size(); shelfIndex++) {
            Shelf currentShelf = shelves.get(shelfIndex);
            ArrayList<Compartment> compartments = currentShelf.getCompartments();
            
            for (int compartmentIndex = 0; compartmentIndex < compartments.size(); compartmentIndex++) {
                Compartment currentCompartment = compartments.get(compartmentIndex);
                
                // Only print if there is an item and it is NOT checked out
                if (currentCompartment.getItem() != null && !currentCompartment.getIsCheckedOut()) {
                    System.out.println("Location: Shelf " + shelfIndex + ", Compartment " + compartmentIndex);
                    System.out.println("Item Details: " + currentCompartment.getItem().toString());
                    System.out.println("----------------------------------------");
                }
            }
        }
    }

    public void printCheckedOutItems() {
        System.out.println("\n========================================");
        System.out.println("          CHECKED OUT ITEMS             ");
        System.out.println("========================================");
        
        ArrayList<Shelf> shelves = libraryStorage.getShelves();
        
        for (int shelfIndex = 0; shelfIndex < shelves.size(); shelfIndex++) {
            Shelf currentShelf = shelves.get(shelfIndex);
            ArrayList<Compartment> compartments = currentShelf.getCompartments();
            
            for (int compartmentIndex = 0; compartmentIndex < compartments.size(); compartmentIndex++) {
                Compartment currentCompartment = compartments.get(compartmentIndex);
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
