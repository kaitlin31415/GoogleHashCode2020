import java.io.*;
import java.util.ArrayList;

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
					}
					System.out.println(l);
				}

				System.out.println(line);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}




	}
}
