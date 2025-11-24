import java.util.ArrayList;

public class Movie extends Item {

//declaring variables
private String title;
private String director;
private ArrayList<String> mainActors;

//constructors
public Movie(){
    super();
    this.title = "";
    this.director = "";
    this.mainActors = new ArrayList<>();
}

public Movie(String n, String d, String id, String t, String drct, ArrayList<String> mnActr){
    super(n, d, id);
    this.title = t;
    this.director = drct;
    this.mainActors = mnActr;
}

//get title, director, main actors
public String getTitle(){
    return title;
}

public String getDirector(){
    return director;
}

public ArrayList<String> getMainActors(){
    return mainActors;
}

//toString overload
@Override
 public String toString() {
    return "||" + getName() + "|" + getDescription() +
    "|" + getID()+ "|" + title + "|" + director +
    "|" + mainActors + "||";
}

}
