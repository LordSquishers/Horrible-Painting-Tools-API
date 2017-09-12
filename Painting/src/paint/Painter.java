package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JPanel;

import main.PaintCode;

public class Painter extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final int MULTIPLIER = 128;
	
	private PaintCode paintCode;
	
	public Painter(PaintCode code) {
		this.paintCode = code;
	}
	
	@SuppressWarnings("rawtypes")
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Iterator it = paintCode.getMap().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        
	        String pos = (String) pair.getKey();
	        String rgb = String.valueOf(pair.getValue());
	        
	        String[] poss = pos.split(";");
	        int x = Integer.parseInt(poss[0]);
	        int y = Integer.parseInt(poss[1]);
	        
	        int red = Integer.parseInt(rgb.substring(0, 3));
	        int green = Integer.parseInt(rgb.substring(3, 6));
	        int blue = Integer.parseInt(rgb.substring(6, rgb.length()));
	      
	        g.setColor(new Color(red, green, blue));
	        g.fillRect(x * MULTIPLIER, y * MULTIPLIER, MULTIPLIER, MULTIPLIER);
	    }
		
		//PIXELS are painted 64x64
	}
	
	public PaintCode getPaintCode() {
		return paintCode;
	}
}
