import java.util.ArrayList;

public class Score{
    public ArrayList<Library> sortedLibraries = new ArrayList<Library>();

    public int getScore(ArrayList<Library> theLibraries, int numDays){
        int totalScore = 0;
        for (int i = 0; i<theLibraries.size(); i++){
            totalScore = 0;
            Library current  = theLibraries.get(i);
            for (int  j = 0; j < current.throughPut(numDays/2); i++){
                   totalScore +=  current.listOfBooks.get(i).score;
            }
            current.score = totalScore;



        }
    } 
}
