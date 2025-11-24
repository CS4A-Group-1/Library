import java.util.Date;

public class Driver {

    // Minimal concrete item for testing, we can just remove this when real subclasses are ready.
    private static final class TestItem extends Item {
        public TestItem(String name, String description, String id) {
            super(name, description, id);
        }
        @Override
        public String toString() {
            return "TestItem{name=" + getName() + ", id=" + getId() + "}";
        }
    }

    private static void step(String label) {
        System.out.println("\n== " + label);
    }

    public static void main(String[] args) {
        LibraryStorage storage = new LibraryStorage();
        LibraryDisplay display = new LibraryDisplay(storage);

        // 1) Add items
        step("Add items");
        Item duneBook = new TestItem("Book: Dune", "placeholder", "BOOK-001");
        Item interstellarMovie = new TestItem("Movie: Interstellar", "placeholder", "MOVIE-002");
        try {
            boolean placedDune = storage.addItem(duneBook, 0, 0);
            boolean placedInterstellar = storage.addItem(interstellarMovie, 0, 1);
            System.out.println("addItem(Dune, 0,0) -> " + placedDune);
            System.out.println("addItem(Interstellar, 0,1) -> " + placedInterstellar);
        } catch (Throwable t) {
            System.out.println("[SKIPPED] addItem not implemented yet");
        }

        // 2) Get items
        step("Get items");
        try {
            System.out.println("getItem(0,0) -> " + storage.getItem(0, 0));
            System.out.println("getItem(0,1) -> " + storage.getItem(0, 1));
        } catch (Throwable t) {
            System.out.println("[SKIPPED] getItem not implemented yet");
        }

         // 3) Checkout using compartment reference from shelf
        step("Checkout via Compartment");
        try {
            Shelf shelf0 = storage.getShelf(0);                   
            Compartment slot00 = shelf0 != null ? shelf0.getCompartment(0) : null;  
            boolean checkedOut;
            if (slot00 != null) {
                checkedOut = storage.checkOutItem(slot00, "Alice", new Date());
                System.out.println("checkOutItem(slot00, Alice, today) -> " + checkedOut);
            } else {
                checkedOut = storage.checkOutItem(0, 0, "Alice", new Date());
                System.out.println("checkOutItem(0,0, Alice, today) -> " + checkedOut);
            }
        } catch (Throwable t) {
            System.out.println("[SKIPPED] checkOutItem not implemented yet");
        }

         // 4) Displays
        step("Displays");
        try {
            display.printItemsInStorage();
            display.printCheckedOutItems();
        } catch (Throwable t) {
            System.out.println("[SKIPPED] display methods not ready");
        }
        
        // 5) Check in
        step("Check in");
        try {
            boolean checkedIn = storage.checkInItem(0, 0);
            System.out.println("checkInItem(0,0) -> " + checkedIn);
        } catch (Throwable t) {
            System.out.println("[SKIPPED] checkInItem not implemented yet");
        }

         // 6) Swap
        step("Swap");
        try {
            Item natureMagazine = new TestItem("Magazine: Nature", "placeholder", "MG-003");
            storage.addItem(natureMagazine, 0, 2);
            boolean swapped = storage.swapItems(0, 1, 0, 2);
            System.out.println("swapItems(0,1) <-> (0,2) -> " + swapped);
            System.out.println("post-swap getItem(0,1) -> " + storage.getItem(0, 1));
            System.out.println("post-swap getItem(0,2) -> " + storage.getItem(0, 2));
        } catch (Throwable t) {
            System.out.println("[SKIPPED] swapItems not implemented yet");
        }

        // 7) Binary I/O
        step("Binary I/O");
        try {
            boolean saved = storage.saveToFile();
            System.out.println("saveToFile() -> " + saved);
            LibraryStorage loaded = storage.loadFromFile();
            System.out.println("loadFromFile() -> " + (loaded != null));
        } catch (Throwable t) {
            System.out.println("[SKIPPED] file I/O not implemented yet");
        }

        System.out.println("\nDone");
    }
}
