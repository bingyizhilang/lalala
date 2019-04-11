package Book;

public class Book {
    private int id;
    private  String name;
    private  double price;
    private String author;

    public Book(){}

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void printBookInfo(){
        System.out.println("My Name is : " + this.name);
    }

    private int getNameLength(){
        return name.length();
    }


    @Override
    public String toString() {
        return this.id +" "+ this.name +" "+ this.price +" "+ this.author;
    }
}
