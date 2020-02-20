public class Library{
    public PriorityQueue<Book> books = new PriorityQueue<>((Book b1, Book b2) -> (- Integer.compare(b1.score,b2.score)));
    public int signUpDelay;
    public int booksPerDay;


}
