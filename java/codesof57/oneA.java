class Book{
    private String title;
    private String author;
    private int publicationYear;

    public void getTitle(){
        System.out.println("Title: " + title);
    }

    public void getAuthor(){
        System.out.println("Author: " + author);
    }

    public void getPublicationYear(){
        System.out.println("Publication Year: " + publicationYear);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }
}

public class oneA{
    public static void main(String[] args){
        Book book1 = new Book();
        Book book2 = new Book();

        //setting
        book1.setTitle("wtf");
        book1.setAuthor("iself");
        book1.setPublicationYear( 2026);
        //setting
        book2.setTitle("ilobu");
        book2.setAuthor("thyself");
        book2.setPublicationYear( 1676);

        //getting book1
        book1.getTitle();
        book1.getAuthor();
        book1.getPublicationYear();

        book2.getTitle();
        book2.getAuthor();
        book2.getPublicationYear();
    }
}
