import java.io.*;

public class main {

	public static void main(String[] args){
		System.out.println("Hello World");
		String file  = "a_example.txt";

		int totalBooks = 0;
		int totalLibraries = 0;
		int numDays = 0;

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

					}
				}

				System.out.println(line);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}




	}
}
