import java.lang.reflect.Array;
import java.util.*;


public class Library{
    private PriorityQueue<Book> books = new PriorityQueue<>((Book b1, Book b2) -> (- Integer.compare(b1.score,b2.score)));
    private PriorityQueue<Book> books2 = new PriorityQueue<>((Book b1, Book b2) -> (- Integer.compare((b1.score - b1.frequency),(b2.score - b1.frequency))));


    public ArrayList<Book> listOfBooks = new ArrayList<Book>();
    public int signUpDelay;
    public int rate;
    public int id;
    public int score;

    public Library (int id, int signUpDelay, int rate){
        this.id = id;
        this.signUpDelay = signUpDelay;
        this.rate = rate;
    }

    public String toString(){
        return "Library: " + id  +"Signup Delay: " + signUpDelay+ "Score: " + score +" With Rate: " + rate +" Books: " + listOfBooks +"\n";

    }
    public void addBook(Book b){
        books.add(b);

    }
    public void finalizeLibrary(){
        while(!books.isEmpty()){
            listOfBooks.add(books2.poll());
        }

    }

    public int throughPut(int days) {
        return (days - signUpDelay) * rate;

    }






}
