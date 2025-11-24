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

          // 3) Checkout
        step("Checkout");
        try {
            boolean checkedOut = storage.checkOutItem(0, 0, "Alice", new Date());
            System.out.println("checkOutItem(0,0, Alice, today) -> " + checkedOut);
        } catch (Throwable t) {
            System.out.println("[SKIPPED] checkOutItem not implemented yet");
        }
