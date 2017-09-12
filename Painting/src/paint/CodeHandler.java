package paint;

import java.util.HashMap;

import main.PaintCode;

public class CodeHandler {

	public PaintCode convertString(String code) {
		HashMap<String, String> newMap = new HashMap<>();
		
		//The screen is 16x16
		
		//FORMAT for String code:
		//X;Y:RGB,X;Y:RGB, etc
		//RGB = 123123123 or 003005004
		
		String[] pixels = code.split(",");
		
		for(String pixel: pixels) {
			String[] posVrgb = pixel.split(":");
			newMap.put(posVrgb[0], posVrgb[1]);
		}
		
		return new PaintCode(newMap);
	}
	
}
