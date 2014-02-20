package com.mmm.findtherythm.utils;

import java.util.HashMap;


public class ScoreUtil {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public static void savePartie(String name, int score) {
		map.put(name, score);
	}
	
	public static HashMap<String, Integer> getListScore() {
		return map;
	}

}
