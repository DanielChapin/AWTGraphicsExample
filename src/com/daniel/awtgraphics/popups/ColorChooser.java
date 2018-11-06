package com.daniel.awtgraphics.popups;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChooser extends JFrame {
	
	private JPanel panel = new JPanel();
	private static JColorChooser colorPicker = new JColorChooser();
	
	public ColorChooser() {
		setTitle("Color Picker");
		setContentPane(panel);
		setSize(620, 350);
		panel.add(colorPicker);
	}
	
	public static Color getSelectedColor() {
		return colorPicker.getColor();
	}
	
}
