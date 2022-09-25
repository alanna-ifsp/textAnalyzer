import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteFile {
	
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
