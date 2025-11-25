//*****************************************************************
// Handle cases when argument object is null
//*****************************************************************

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class LibraryStorage implements Serializable {
    
    //===============================================
    //  Data

    private ArrayList<Shelf> libraryShelves;

    //===============================================
    //  Constructors

    public LibraryStorage() {
        this.libraryShelves = new ArrayList<>();
    }

    //===============================================
    //  Shelves
    
    public ArrayList<Shelf> getShelves() {
        return new ArrayList<>(this.libraryShelves);
    }

    public void addShelf(Shelf shelf) {
        if (shelf == null) {
            throw new IllegalStateException("Shelf cannot be null.");
        }
        this.libraryShelves.add(shelf);
    }

    //===============================================
    //  Items

    public boolean addItem(Item item, int shelf, int compartment) {
        if (item == null) {
            throw new IllegalStateException("Item cannot be null.");
        }
        try {
            Shelf selectedShelf = this.libraryShelves.get(shelf);
            return selectedShelf.setCompartment(item, compartment);
        } catch (IndexOutOfBoundsException  ex){
            return false;
        }
    }

    public boolean replaceItem(Item item, int shelf, int compartment) {
        if (item == null) {
            throw new IllegalStateException("Item cannot be null.");
        }
        try {
            Shelf selectedShelf = this.libraryShelves.get(shelf);
            selectedShelf.removeCompartment(compartment);
            return selectedShelf.setCompartment(item, compartment);
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public Compartment getCompartment(int shelf, int compartment) {
        try {
            Shelf selectedShelf = this.libraryShelves.get(shelf);
            Compartment selectedCompartment = selectedShelf.getCompartment(compartment);
            return selectedCompartment;
        }
        catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }
    
    public Date checkOutItem(Compartment compartment, String borrower) {
        if (compartment == null) {
            throw new IllegalStateException("Compartment cannot be null.");
        }
        if (!compartment.getIsCheckedOut()) {
            compartment.checkOut(borrower);
            return compartment.getDueDate();
        } else
            return null;
    }
    
    public boolean checkInItem(Compartment compartment) {
        if (compartment == null) {
            throw new IllegalStateException("Compartment cannot be null.");
        }
        if (compartment.getIsCheckedOut()) {
            compartment.checkIn();
            return true;
        } else return false;
    }

    public ArrayList<Item> getCheckedInItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (Shelf shelf: this.libraryShelves) {
            Compartment[] compartments = shelf.getCompartments();
            for (Compartment c: compartments) {
                if (!c.getIsCheckedOut()) {
                    items.add(c.getItem());
                }
            }
        }
        return items;
    }

    public ArrayList<Item> getCheckedOutItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (Shelf shelf: this.libraryShelves) {
            Compartment[] compartments = shelf.getCompartments();
            for (Compartment c: compartments) {
                if (c.getIsCheckedOut()) {
                    items.add(c.getItem());
                }
            }
        }
        return items;
    }

    public boolean swapItems(int shelf1, int compartment1, int shelf2, int compartment2) {
        try {
            Shelf selectedShelf1 = this.libraryShelves.get(shelf1);
            Compartment selectedCompartment1 = selectedShelf1.getCompartment(compartment1);
            Item item1 = selectedCompartment1.getItem();
            selectedShelf1.removeCompartment(compartment1);
            Shelf selectedShelf2 = this.libraryShelves.get(shelf2);
            Compartment selectedCompartment2 = selectedShelf2.getCompartment(compartment2);
            Item item2 = selectedCompartment2.getItem();
            selectedShelf2.removeCompartment(compartment2);
            if ((selectedCompartment1.getIsCheckedOut() == false) && (selectedCompartment2.getIsCheckedOut() == false)) {
                if (selectedShelf2.setCompartment(item1, compartment2)) {
                    return (selectedShelf1.setCompartment(item2, compartment1));
                } else {
                    return false;
                }
            } else return false;
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }
}