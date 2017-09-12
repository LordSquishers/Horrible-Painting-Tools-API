package main;

import java.util.HashMap;

public class PaintCode {

	//Position, value
	private HashMap<String, String> map;
	
	public PaintCode(HashMap<String, String> mapInsert) {
		map = mapInsert;
	}
	
	public String getColorPerPosition(int x, int y) {
		String key = x + ";" + y;
		return map.get(key);
	}
	
	public HashMap<String, String> getMap() {
		return map;
	}
	
}
