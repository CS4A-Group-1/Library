public class Book extends Item {

    //declaring variables
    private String title;
    private String author;
    private String copyrightDate;

    //constructor
    public Book() {
        super();
        this.title = "";
        this.author = "";
        this.copyrightDate = "";
    }

    public Book(Book other) {
        super(other);   // calls Item(Item other)
        this.title = other.title;
        this.author = other.author;
        this.copyrightDate = other.copyrightDate;
    }

    //overloaded constructor
    public Book(String n, String d, String id, String t, String a, String c) {
        super(n, d, id);
        this.title = t;
        this.author = a;
        this.copyrightDate = c;
    }

    //get title, author, copyright
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCopyrightDate() {
        return copyrightDate;
    }

    //toString overload
    @Override
    public String toString() {
        return "|" + getName() + "|" + getDescription() +
        "|" + getID()+ "|" + title + "|" + author +
        "|" + copyrightDate + "|";
    }

}
