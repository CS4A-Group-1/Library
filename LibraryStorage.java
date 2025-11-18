import java.io.*;
import java.util.Date;

public class LibraryStorage implements Serializable {
    
    //===============================================
    //  Data

    // TODO
    // private ArrayList<Shelf> libraryShelves;


    //===============================================
    //  Constructors

    // TODO
    public LibraryStorage() {
        // this.libraryShelves = new ArrayList<Shelf>;
    }

    //===============================================
    //  Shelves
    
    // TODO
    // public ArrayList<Shelf> getShelves() {
    //     return new ArrayList<Shelf>(this.libraryShelves);
    // }

    // TODO
    // public void addShelf(Shelf shelf) {
    //     this.libraryShelves.add(shelf);
    // }

    //===============================================
    //  Items

    // TODO
    // public boolean addItem(Item item, int shelf, int compartment) {
    //     // check compartment at shelf
    //     try {
    //         Shelf selectedShelf = this.libraryShelves.get(shelf);
    //         Compartment selectedCompartment = selectedShelf.getCompartments().get(compartment);
    //         // if compartment has an item, return false
    //         if (selectedCompartment.getItem() != null) {
    //             return false;
    //         } else
    //             // do we just go with swapping the old compartment with a new one
    //             // (deep copy of shelf compartments?)
    //             selectedCompartment.setItem(item);
    //             selectedShelf.setCompartment(selectedCompartment);
    //             return true;
    //     }
    //     catch (IndexOutOfBoundsException ex) {
    //         return false;
    //     }
    // }

    // TODO
    // public void replaceItem(Item item, int shelf, int compartment) {

    // }

    // TODO
    // public void getItem(int shelf, int compartment) {

    // }

    // TODO
    // public Date checkOutItem(Compartment compartment) {
    //     return new Date();
    // }

    // TODO
    // public void checkInItem(Compartment compartment) {

    // }

    // TODO
    // public ArrayList<Item> getCheckedInItems() {
    //     return new ArrayList<Item>;
    // }

    // TODO
    // public ArrayList<Item> getCheckedOutItems() {
    //     return new ArrayList<Item>;
    // }

    // TODO
    // public boolean swapItems(int shelf1, int compartment1, int shelf2, int compartment2) {
    //     return false;
    // }

}