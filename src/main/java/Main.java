

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {
			Analyzer analyzer = new Analyzer();
			Scanner in = new Scanner(System.in);
			String nameFile = "";

			System.out
					.println("Enter the files separated by comma (without the file extension) that you want to analyze");
			nameFile = in.next();
			in.close();
			String[] fileNamesSeparator = nameFile.split(",");

			for (int i = 0; i < fileNamesSeparator.length; i++)
				analyzer.analyzer(fileNamesSeparator[i]);
			
			System.out.println("Text analyzed successfully! Files are available in the folder!");
			
		}

		catch (Exception e) {
			System.out.println("Process not completed:  " + e.getMessage());
		}

	}

}
