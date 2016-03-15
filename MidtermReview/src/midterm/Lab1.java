package midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab1 {

	public static void main(String[] args) {
		String fileName = "people.ssv";
		ArrayList<String> names = new ArrayList<>();
		int index = 0;
		int highestNumber = 0, highestIndex = 0;
		double average = 0.0;
		// This will reference one line at a time

		try {
			// FileReader reads text files in the default encoding.
			File fileReader = new File(fileName);

			// Always wrap FileReader in BufferedReader.
			Scanner input = new Scanner(fileReader);

			while (input.hasNextLine()) {
				String line = input.nextLine();

				StringTokenizer st = new StringTokenizer(line, ";");
				names.add(st.nextToken());
				int middle = Integer.parseInt(st.nextToken());

				if (middle > highestNumber) {
					highestNumber = middle;
					highestIndex = index;
				}
				average += Double.parseDouble(st.nextToken());

				index++;
			}

			// Always close files.
			input.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

		System.out.println("Average is: " + (average / index));
		System.out.println("Highest number person was: " + names.get(highestIndex));
	}

}
