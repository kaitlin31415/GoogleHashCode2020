import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class main {

	public static void main(String[] args){
		System.out.println("Hello World");
		String file  = "a_example.txt";

		int totalBooks = 0;
		int totalLibraries = 0;
		int numDays = 0;
		ArrayList<Book> allBooks = new ArrayList<Book>();
		ArrayList<Library> allLibraries = new ArrayList<Library>();

		int idStart = 0;

		int count = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				// process the line.
				if (count == 0) {

					String[] params = line.split(" ");
					totalBooks = Integer.parseInt(params[0]);
					totalLibraries = Integer.parseInt(params[1]);
					numDays = Integer.parseInt(params[2]);

				} else if (count == 1) {
					String[] params = line.split(" ");
					for (int i = 0; i< params.length; i++){
						allBooks.add(new Book(i, Integer.parseInt(params[i])));
					}
				} else {
					String[] params = line.split(" ");

					Library l = new Library(idStart, Integer.parseInt(params[1]), Integer.parseInt(params[2]));

					idStart++;
					allLibraries.add(l);
					line = br.readLine();
					String[] params2 = line.split( " ");
					for (int i = 0; i < Integer.parseInt(params[0]); i++){
						l.addBook(allBooks.get(Integer.parseInt(params2[i])));
						allBooks.get(Integer.parseInt(params2[i])).frequency++;
					}
					l.finalizeLibrary();

				}

				count++;
			}

			System.out.println(allLibraries);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Score.getScores(allLibraries, numDays);
		Collections.sort(allLibraries, (Library l1, Library l2) -> (- Integer.compare(l1.score,l2.score)));

		//Print the output
		ArrayList<String> allLines = new ArrayList<String>();

		int numLibs = 0;
		int numBooksForCurrentLib = 0;
		int currentLib = 0;



		while (true){
			String toReturn = "";
			if ( numLibs == allLibraries.size() || numDays <allLibraries.get(currentLib).signUpDelay){
				break;
			}

			Library current =  allLibraries.get(currentLib);
			numLibs++;


			int numIterations = Integer.min(current.listOfBooks.size(), current.throughPut(numDays));
			int i = 0;

			String allBooksAsString = "";
			while (i < numIterations){
				if (!current.listOfBooks.get(i).scanned){
					current.listOfBooks.get(i).scanned = true;
					allBooksAsString +=  "" + current.listOfBooks.get(i).id + " ";
					numBooksForCurrentLib++;
				} else {
					if (numIterations+1 <= current.listOfBooks.size()){
							numIterations++;
					} else {
						numIterations = current.listOfBooks.size();

					}


				}
				i++;
			}
			String lib = "" + current.id + " " + numBooksForCurrentLib +"\n";
			String books = allBooksAsString + "\n";

			allLines.add(lib);
			allLines.add(books);


			numDays-= current.signUpDelay;

			currentLib++;
			numBooksForCurrentLib = 0;



		}
		allLines.add(0,  "" + numLibs + "\n");
		System.out.println(allLines);

	}
}
