import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Class responsible for write csv file
 *
 */
public class WriteFile {
	
	/**
	 * Method responsbile for write file in extension .csv. This Method receive TreeMap and write file with all nodes and edges
	 * @param text - TreeMap with nodes and edges
	 * @param nameFile - name of file
	 * @throws Exception - Exception when write file
	 */
	public void writeFile(TreeMap<String, Set<String>>text,String nameFile) throws Exception 
	{
		try
		{
			PrintWriter writer = new PrintWriter(nameFile + ".csv", "UTF-8");
			for (Map.Entry<String,Set<String>> line : text.entrySet())
			{
					writer.print(line.getKey() + ";");
					line.getValue().forEach(destination->{writer.print(destination+";");});
					writer.print("\n");
			}
			writer.close();
		}
		catch(Exception e)
		{
			throw new Exception("Error writing file: " + e.getMessage());
		}
	
	}
	
}
