import java.io.*;
public abstract class Item implements Serializable {
    //declaring variables
    private String name;
    private String description;
    private String id;

    protected Item(){
        this.name = "";
        this.description = "";
        this.id = "";
    }

    protected Item(Item other) {
        this.name = other.name;
        this.description = other.description;
        this.id = other.id;
    }

    protected Item(String n, String d, String i){
        this.name = n;
        this.description = d;
        this.id = i;
    }

    //get name, description, ID
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getID(){
        return id;
    }

}

