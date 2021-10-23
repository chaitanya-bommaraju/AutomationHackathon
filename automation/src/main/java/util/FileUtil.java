package util;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtil {

	public JSONArray readJSON(String filePath) throws Exception
	{
	
	JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader(filePath);
    //Read JSON file
    Object obj = jsonParser.parse(reader);
    return (JSONArray) obj;
	}
	
	public boolean validateJSONKeyValue(JSONArray jarray,String collectionName, String key, String value)
	{
		for (Object parse_obj : jarray)
		{
			JSONObject obj = (JSONObject) parse_obj;
			JSONObject item = (JSONObject) obj.get(collectionName);
			
		if(item.get(key).toString().equals(value))
		{
			return true;
		}
		else
		{
			return false;
		}
			
		}
		return false;
	}
	
}
