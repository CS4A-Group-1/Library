import java.util.ArrayList;

public class Shelf {
    private static final int Max = 15;
    private String section;
    private Compartment[] compartments;

    //default
    public Shelf() {
        this.section = "";
        this.compartments = new Compartment[Max];
    }

    public void setSection(String s) {
        this.section = s;
    }

    public String getSection() {
        return this.section;
    }

    public void removeCompartment(int i){
        if (i < 0 || i >= compartments.length) {
            throw new IndexOutOfBoundsException("Invalid compartment index.");
        }
        
        compartments[i] = null;
    }

    public Compartment getCompartment(int i) {
        if (i < 0 || i >= compartments.length) {
            throw new IndexOutOfBoundsException("Invalid compartment index.");
        }
        return compartments[i];
    }

    public Compartment[] getCompartments() {
        Compartment[] deepCopy = new Compartment[Max];

        for(int i = 0; i < Max; i++){
            if (compartments[i] != null){
                deepCopy[i] = new Compartment(compartments[i]);
            }
        }

        return deepCopy;
    }

    //add a new compartment with a item
    public boolean setCompartment(Item item, int i) {
        if (i < 0 || i >= compartments.length) {
            throw new IndexOutOfBoundsException("Invalid compartment index.");
        }

        if(compartments[i] != null){
            compartments[i] = new Compartment(item);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Section: " + section);
        for (int i = 0; i < compartments.length; i++) {
            sb.append("Compartment ").append(i).append(": ")
              .append(compartments[i].toString());
        }
        return sb.toString();
    }
}