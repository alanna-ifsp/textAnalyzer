

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {
			Analyzer analyzer = new Analyzer();
			Scanner in = new Scanner(System.in);
			String nameFile = "";

			System.out
					.println("Insira, separado por vírgulas o nomes dos arquivos (sem a extensão) que deseja analisar");
			nameFile = in.next();
			in.close();
			String[] fileNamesSeparator = nameFile.split(",");

			for (int i = 0; i < fileNamesSeparator.length; i++)
				analyzer.analyzer(fileNamesSeparator[i]);
			
			System.out.println("Texto analisado com sucesso! Arquivos já estão disponíveis na pasta!");
		}

		catch (Exception e) {
			System.out.println("Processo não foi concluído:  " + e.getMessage());
		}

	}

}
