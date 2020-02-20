
public class Book{
    public int id;
    public int score;
    public boolean scanned = false;
    public int frequency = 0;

    public Book(int bookID, int scr){
        id = bookID;
        score = scr;
    }

    @Override
    public String toString() {
        return "B" + id + " Score: " + score +" Frequency:" + frequency;
    }
}
