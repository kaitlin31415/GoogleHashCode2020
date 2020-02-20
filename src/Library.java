import java.lang.reflect.Array;
import java.util.*;


public class Library{
    public PriorityQueue<Book> books = new PriorityQueue<>((Book b1, Book b2) -> (- Integer.compare(b1.score,b2.score)));
    public ArrayList<Book> listOfBooks = new ArrayList<Book>();
    public int signUpDelay;
    public int rate;
    public int id;

    public Library (int id, int signUpDelay, int rate){
        this.id = id;
        this.signUpDelay = signUpDelay;
        this.rate = rate;
    }

    public String toString(){
        return "Library: " + id  +"Signup Delay: " + signUpDelay+ " With Rate: " + rate +" Books: " + listOfBooks;

    }
    public void addBook(Book b){
        books.add(b);
        listOfBooks.add(b);

    }

    public int throughPut(int days) {
        return (days - signUpDelay) * rate;

    }






}
