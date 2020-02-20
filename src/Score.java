import java.util.ArrayList;

public class Score{


    public static void getScores(ArrayList<Library> theLibraries, int numDays){
        int totalScore = 0;
        for (int i = 0; i<theLibraries.size(); i++){
            totalScore = 0;
            Library current  = theLibraries.get(i);
            for (int  j = 0; j < Integer.min(current.listOfBooks.size(), current.throughPut(numDays/2)); j++){
                   totalScore +=  current.listOfBooks.get(j).score - current.listOfBooks.get(j).frequency;
            }
            current.score = totalScore;



        }

    } 
}
