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
        this.libraryShelves = new ArrayList<Shelf>();
    }

    //===============================================
    //  Shelves
    
    public ArrayList<Shelf> getShelves() {
        return new ArrayList<Shelf>(this.libraryShelves);
    }

    // TODO -> check if a SHELF exists, if one doesn't then add it
    public void addShelf(Shelf shelf) {
        if (shelf != null) {
            this.libraryShelves.add(shelf);
        }
    }

    //===============================================
    //  Items

    // TODO -> check if a COMPARTMENT exists, if one doesn't then add it
    public boolean addItem(Item item, int shelf, int compartment) {
        // check compartment at shelf
        try {
            Shelf selectedShelf = this.libraryShelves.get(shelf);
            Compartment selectedCompartment = selectedShelf.getCompartment(compartment);
            // if compartment has an item, return false
            if (selectedCompartment.getItem() != null) {
                return false;
            } else {
                Compartment newCompartment = new Compartment(item);
                selectedShelf.setCompartment(newCompartment, compartment);
                return true;
            }
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    // TODO -> check if an Item exists, if one doesn't then add it
    public boolean replaceItem(Item item, int shelf, int compartment) {
        try {
            Shelf selectedShelf = this.libraryShelves.get(shelf);
            if (!selectedShelf.getCompartment(compartment).getIsCheckedOut()) {
                Compartment newCompartment = new Compartment(item);
                selectedShelf.setCompartment(newCompartment, compartment);
                return true;
            } 
            else return false;
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public Compartment getCompartment(int shelf, int compartment) {
        try {
            Shelf selectedShelf = this.libraryShelves.get(shelf);
            Compartment selectedCompartment = selectedShelf.getCompartment(compartment);
            if (!selectedCompartment.getIsCheckedOut()) 
                return selectedCompartment;
            else return null;
        }
        catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }
    
    // TODO -> check if a COMPARTMENT exists, if one doesn't then add it
    public Date checkOutItem(Compartment compartment, String borrower) {
        if (!compartment.getIsCheckedOut()) {
            compartment.checkOut(borrower);
            return compartment.getDueDate();
        } else
            return null;
    }
    
    // TODO -> check if a COMPARTMENT exists, if one doesn't then add it
    public boolean checkInItem(Compartment compartment) {
        if (compartment.getIsCheckedOut()) {
            compartment.checkIn();
            return true;
        } else return false;
    }

    public ArrayList<Item> getCheckedInItems() {
        ArrayList<Item> items = new ArrayList<>();
        for (Shelf shelf: this.libraryShelves) {
            ArrayList<Compartment> compartments = shelf.getCompartments();
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
            ArrayList<Compartment> compartments = shelf.getCompartments();
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
            Shelf selectedShelf2 = this.libraryShelves.get(shelf2);
            Compartment selectedCompartment2 = selectedShelf2.getCompartment(compartment2);
            if ((selectedCompartment1.getIsCheckedOut() == false) && (selectedCompartment2.getIsCheckedOut() == false)) {
                selectedShelf2.setCompartment(selectedCompartment1, compartment2);
                selectedShelf1.setCompartment(selectedCompartment2, compartment1);
                return true;
            } else return false;
        }
        catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }
}