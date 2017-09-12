package paint;

import javax.swing.JFrame;

import main.PaintCode;

public class PaintMaster {

	private CodeHandler handler;
	private PaintCode paintCode;
	private String currentCode;
	
	public PaintMaster() {
		handler = new CodeHandler();
	}
	
	public void setCode(String code) {
		currentCode = code;
		convertRawCode();
	}
	
	private void convertRawCode() {
		paintCode = handler.convertString(currentCode);
	}
	
	public void paint() {
		JFrame f = new JFrame("Painting");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Painter g = new Painter(paintCode);
		f.add(g);
		f.setSize(1024, 1024);
		f.setVisible(true);
	}
	
}
