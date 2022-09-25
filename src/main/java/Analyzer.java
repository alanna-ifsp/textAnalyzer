import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Analyzer {

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

			if (!wordsDestination.isEmpty())
				result.put(node, wordsDestination);
		}

		return result;
	}

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
