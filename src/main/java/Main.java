

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {
			Analyzer analyzer = new Analyzer();
			Scanner in = new Scanner(System.in);
			String nameFile = "";

			System.out
					.println("Insira, separado por v�rgulas o nomes dos arquivos (sem a extens�o) que deseja analisar");
			nameFile = in.next();
			in.close();
			String[] fileNamesSeparator = nameFile.split(",");

			for (int i = 0; i < fileNamesSeparator.length; i++)
				analyzer.analyzer(fileNamesSeparator[i]);
			
			System.out.println("Texto analisado com sucesso! Arquivos j� est�o dispon�veis na pasta!");
		}

		catch (Exception e) {
			System.out.println("Processo n�o foi conclu�do:  " + e.getMessage());
		}

	}

}
