import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * Class responsible for processing analyzer text of file
 * 
 */

public class Analyzer {

	/**
	 * Method responsible for processing all text of file, declare nodes and edge words. 
	 * @param allWordsOfFile - List of all words of file
	 */
	private TreeMap<String, Set<String>> processing(List<String> allWordsOfFile) {

		Set<String> nodes = new HashSet<String>();
		nodes.addAll(allWordsOfFile);

		TreeMap<String, Set<String>> result = new TreeMap<String, Set<String>>();

		for (String node : nodes) {
			Set<String> wordsDestination = new HashSet<String>();

			for (int i = 0; i < allWordsOfFile.size() - 1; i++) {
				if (allWordsOfFile.get(i).equals(node)) {
					wordsDestination.add(allWordsOfFile.get(i + 1));
				}
			}

			/*Only nodes with edge can are in List*/
			if (!wordsDestination.isEmpty())
				result.put(node, wordsDestination);
		}

		return result;
	}

	/**
	 * Method receive text of file, call processing method and after write the text already processed. 
	 * @param fileName - Name of file 
	 * @throws Exception - Exception when analyzer text
	 */
	public void analyzer(String fileName) throws Exception {
		ReadFile read = new ReadFile();
		WriteFile write = new WriteFile();

		try {
			List<String> allWordsOfFile = new ArrayList<String>();
			allWordsOfFile = read.readFile(fileName);
			TreeMap<String, Set<String>> text = processing(allWordsOfFile);
			write.writeFile(text, fileName);

		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}

	}
}
