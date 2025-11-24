public abstract class Item {
//declaring variables
private String name;
private String description;
private String id;

public Item(){
    this.name = "";
    this.description = "";
    this.id = "";

}

public Item(String n, String d, String i){
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

