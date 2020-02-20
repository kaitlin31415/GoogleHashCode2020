
public class Book{
    public int id;
    public int score;
    public boolean scanned;

    public Book(int bookID, int scr){
        id = bookID;
        score = scr;
    }

    @Override
    public String toString() {
        return "B" + id + " Score: " + score;
    }
}
