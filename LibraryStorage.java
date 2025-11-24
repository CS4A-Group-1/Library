//*****************************************************************
// FOR ADDITEM()
// how do we check if a spot is a valid place to add a compartment?
//.  - compartments always have items
//.  - shelves always have 15 compartments
//   - might be the same as replace item

// checkOutItem may require a string to be passed instead of just
//  the compartment

// how do we feel about return nulls and booleans instead of
//  'void' on some of these
//*****************************************************************

import java.io.*;
import java.util.Date;

public class LibraryStorage implements Serializable {
    
    //===============================================
    //  Data

    // TODO
    // private ArrayList<Shelf> libraryShelves;
    private String tempStorage;

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
    //             Compartment newCompartment = new Compartment(item)
    //             selectedShelf.setCompartment(newCompartment);
    //             return true;
    
    //     }
    //     catch (IndexOutOfBoundsException ex) {
    //         return false;
    //     }
    // }

    // TODO
    // public boolean replaceItem(Item item, int shelf, int compartment) {
    //      try {
    //          Shelf selectedShelf = this.libraryShelves.get(shelf);
    //          if (!selectedShelf.getCompartment(compartment).getIsCheckedOut()) {
        //          Compartment newCompartment = new Compartment(item);
        //          selectedShelf.setComaprtment(newCompartment, comapartment)
        //          return true;
        //      } else return false;
    //      }
    //      (catch IndexOutOfBoundsException ex) {
    //          return false;
    //      }
    // }

    // TODO
    // public Item getItem(int shelf, int compartment) {
            // try {
            //     Shelf selectedShelf = this.libraryShelves.get(shelf);
            //     Compartment selectedCompartment = selectedShelf.getCompartment(compartment);
            //      if (selectedCompartment.getIsCheckedOut()) 
            //          return selectedCompartment.getItem();
            //      else return null;
            // }
            // (catch IndexOutOfBoundsException ex) {
    //          return null;
    //      }
    // }

    // TODO
    // public Date checkOutItem(Compartment compartment, String borrower) {
    //      if (!compartment.getIsCheckedOut()) {
    //          compartment.checkOut(borrower);
    //          return compartment.getDueDate();
    //      } else
    //          return null;
    // }

    // TODO
    // public boolean checkInItem(Compartment compartment) {
    //      if (compartment.getIsCheckedOut()) {
    //           compartment.checkInItem();
    //           return true;
    //      } else return false;
    // }

    // TODO
    // public ArrayList<Item> getCheckedInItems() {
    //     ArrayList<Item> items = new ArrayList<>;
    //      for (Shelf shelf: this.shelves) {
    //          ArrayList<Compartment> compartments = shelf.getCompartments();
    //          for (Compartment c: compartments) {
    //              if (!c.getIsCheckedOut()) {
    //                  items.append(c);
    //              }
    //          }
    //      }
    //     return items;
    // }

    // TODO
    // public ArrayList<Item> getCheckedOutItems() {
    //     ArrayList<Item> items = new ArrayList<>;
    //      for (Shelf shelf: this.shelves) {
    //          ArrayList<Compartment> compartments = shelf.getCompartments();
    //          for (Compartment c: compartments) {
    //              if (c.getIsCheckedOut()) {
    //                  items.append(c);
    //              }
    //          }
    //      }
    //     return items;
    // }

    // TODO
    // public boolean swapItems(int shelf1, int compartment1, int shelf2, int compartment2) {
            // try {
            //     Shelf selectedShelf1 = this.libraryShelves.get(shelf1);
            //     Compartment selectedCompartment1 = selectedShelf1.getCompartment(compartment1);
            //     Shelf selectedShelf2 = this.libraryShelves.get(shelf2);
            //     Compartment selectedCompartment2 = selectedShelf2.getCompartment(compartment2);
            //     if ((selectedCompartment1.getIsCheckedOut() == false) && (selectedCompartment2.getIsCheckedOut() == false)) {
            //         selectedShelf2.setCompartment(selectedCompartment1);
            //         selectedShelf1.setComaprtment(selectedCompartment2);
            //         return true;
            //     } else return false;

            // }
            // catch (IndexOutOfBoundsException ex) {
            //     return false;
            // }
    // }

}