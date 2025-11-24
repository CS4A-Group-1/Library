import java.util.ArrayList;

public class Shelf {
    private static final int Max = 15;
    private String section;
    private ArrayList<Compartment> compartments;

    //default
    public Shelf() {
        this.section = "";
        this.compartments = new ArrayList<>();
    }

    //constructor with compartments
    public Shelf(ArrayList<Compartment> c) {
        if (c.size() > Max) {
            throw new IllegalArgumentException("Shelf cannot have more than " + Max + " compartments.");
        }
        this.section = "";
        this.compartments = new ArrayList<>(c);
    }

    public void setSection(String s) {
        this.section = s;
    }

    public String getSection() {
        return this.section;
    }

    // Replace compartment at index
    public void setCompartment(Compartment c, int i) {
        if (i < 0 || i >= compartments.size()) {
            throw new IndexOutOfBoundsException("Invalid compartment index.");
        }
        compartments.set(i, c);
    }

    public Compartment getCompartment(int i) {
        if (i < 0 || i >= compartments.size()) {
            throw new IndexOutOfBoundsException("Invalid compartment index.");
        }
        return compartments.get(i);
    }

    public ArrayList<Compartment> getCompartments() {
        return new ArrayList<>(compartments); 
    }

    //add a new compartment with a item
    public boolean addCompartment(Item item) {
        if (compartments.size() >= Max) {
            return false; 
        }
        compartments.add(new Compartment(item));
        return true;
    }

    // Swap two differ compartments 
    // READ!!!!! pretty sure we said we didnt want this in shelf but i added it because i wasnt sure delete if not needed
    /*public void swapCompartments(int i, int j) {
        if (i < 0 || j < 0 || i >= compartments.size() || j >= compartments.size()) {
            throw new IndexOutOfBoundsException("Invalid compartment index.");
        }
        Compartment temp = compartments.get(i);
        compartments.set(i, compartments.get(j));
        compartments.set(j, temp);
    }*/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Section: " + section + "\n");
        for (int i = 0; i < compartments.size(); i++) {
            sb.append("Compartment ").append(i).append(": ")
              .append(compartments.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}