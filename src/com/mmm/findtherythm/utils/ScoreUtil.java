package com.mmm.findtherythm.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ScoreUtil {
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public static void savePartie(String name, int score) {
		System.out.println("saved");
		JSONParser parser = new JSONParser();
		

		try { 
			Object obj = parser.parse(new FileReader("score.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray scores = (JSONArray) jsonObject.get("scores");
			
			JSONObject object = new JSONObject();
			object.put("name", name);
			object.put("score", score);
			scores.add(obj);
			
			FileWriter file = new FileWriter("score.json");
			file.write(scores.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static HashMap<String, Integer> getListScore() {
		HashMap map = new HashMap<String, Integer>();
		JSONParser parser = new JSONParser();
		try {
	 
			Object obj = parser.parse(new FileReader("score.json"));
	 
			JSONObject jsonObject = (JSONObject) obj;

			// loop array
			JSONArray scores = (JSONArray) jsonObject.get("scores");
			Iterator<JSONObject> iterator = scores.iterator();
			while (iterator.hasNext()) {
				map.put((String) iterator.next().get("name"), (Integer) iterator.next().get("name"));
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return map;
	}

}
