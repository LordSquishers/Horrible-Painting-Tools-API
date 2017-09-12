package main;

import javax.swing.JOptionPane;

import paint.PaintMaster;

public class Base {
	
	public static void main(String args[]) {
		PaintMaster painter = new PaintMaster();
		boolean running = true;
		
		while(running) {
			String code = JOptionPane.showInputDialog("What is the paint code?");
			
			if(code == "e") running = false;
			
			painter.setCode(code);
			painter.paint();
		}
	}
}
