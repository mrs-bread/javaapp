import java.util.Comparator;

public class Book {
    private int price;
    private int age;
    private int cpage;
    private String author;
    private String NameBook;
    Book(int price, int age, int cpage, String author, String NameBook){
        this.price=price;
        this.age=age;
        this.cpage=cpage;
        this.author=author;
        this.NameBook=NameBook;
    }

    int getPrice(){return price;}
    int getAge(){return age;}
    int getCpage(){return cpage;}
    String getAuthor(){return author;}
    String getNameBook(){return NameBook;}
    public String toString(){
        return "Название книги:"+NameBook+" ,Автор: "+author+" ,Год: "+age+" ,Кол-во страниц: "+cpage+" ,Стоимость: "+price;
    }

    String Print(){
        return ("Название книги:"+NameBook+"\nАвтор: "+author+"\nГод: "+age+"\nКол-во страниц: "+cpage+"\nСтоимость: "+price);
    }

    public static Comparator<Book> kolComparator=new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getCpage()-b2.getCpage();
        }
    };

    public static Comparator<Book> authorComporator=new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getAuthor().compareTo(b2.getAuthor());
        }
    };

}