import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
	// args : 0 -> dataSet
	public static void main(String[] args) throws IOException {
	
		try {
			JSONParser parser = new JSONParser();
			Scanner in = new Scanner(new File(args[0]));
			while(in.hasNextLine())
			{
				String entry = in.nextLine();
				System.out.println(entry);
				Object obj = parser.parse(entry);
				JSONObject jsonObject = (JSONObject) obj;

				String user_id = (String) jsonObject.get("user_id");
				String business_id = (String) jsonObject.get("business_id");
				Long stars = (Long)jsonObject.get("stars");
				System.out.println("User : " + user_id + " - business " + business_id + "- stars " + stars);
			} 
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Error : Require dataset path in argument!");
			e.printStackTrace();
		}
		
	} 
}