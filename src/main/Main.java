package main;

import javax.swing.JFrame;

import constant.WindowConstant;
import swing.TPanel;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame(WindowConstant.WINDOWS_TITLE);
		frame.setSize(WindowConstant.WIDTH, WindowConstant.HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TPanel panel = new TPanel();
		frame.add(panel);
		frame.setVisible(true);
	}

}
