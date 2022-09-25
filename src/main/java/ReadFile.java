
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	private String formatText(String text) {

		String returnText = text;
		returnText = Normalizer.normalize(returnText, Normalizer.Form.NFD);
		returnText = returnText.replaceAll("[^\\p{ASCII}]", "");
		returnText = returnText.replaceAll("[\\p{Punct}]", "");
		returnText = returnText.replaceAll("\r", " ");
		returnText = returnText.replaceAll("\n", "");
		return returnText.toLowerCase();
	}

	private List<String> wordSeparator(String text) {
		List<String> wordsOfFile = new ArrayList<String>();

		for (String word : text.split(" ")) {
			wordsOfFile.add(word);
		}

		return wordsOfFile;
	}

	public List<String> readFile(String filePath) throws Exception {
		try {
			
			String textOfFile = new String(Files.readAllBytes(Paths.get(filePath + ".txt")));

			if (textOfFile.isEmpty())
				throw new Exception(new Exception("Empty file!"));

			textOfFile = formatText(textOfFile);
			return wordSeparator(textOfFile);
		} catch (NoSuchFileException e) {
			throw new Exception("File not found!");
		} catch (Exception e) {
			throw new Exception("Error reading file: " + e.getMessage());
		}
	}

}
