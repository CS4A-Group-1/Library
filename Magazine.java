public class Magazine extends Item {
//declaring variables
public String title;
public String edition;

//constructors
public Magazine(){
    super();
    this.title = "";
    this.edition = "";
}

public Magazine(String n, String d, String id, String t, String e){
    super(n, d, id);
    this.title = t;
    this.edition = e;

}

//get title, edition
public String getTitle(){
    return title;
}

public String getEdition(){
    return edition;
}

//toString overload
@Override
 public String toString() {
    return "||" + getName() + "|" + getDescription() +
    "|" + getID()+ "|" + title + "|" + edition + "||";
}

}
