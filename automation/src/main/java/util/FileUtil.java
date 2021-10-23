package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;


public class FileUtil {

	public static void readJSON(String filePath) throws Exception
	{
	
	
	}
	public static HashMap<String,String> readJSON(String jsonString,String collectionName)
	{
		HashMap<String,String> retObj=null;
		JSONObject obj = new JSONObject(jsonString);
		JSONArray arr = obj.getJSONArray("0001");	
		Set<String> key = arr.getJSONObject(0).keySet();
		for(int i=0; i<key.size();i++)
		{
			retObj.put(key.iterator().next(),arr.getJSONObject(0).getString(key.iterator().next()));
		}
		
		return retObj;
	}
	
}
