package com.daniel.awtgraphics.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.daniel.awtgraphics.objects.Drawable;

public class DrawingPanel extends JPanel {
	
	public ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
	public boolean tutorial = true;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f));
		
		g.setColor(new Color(0f, 0.5f, 0.5f));
		for(int i = 0; i < drawables.size(); i++) {
			g.setColor(drawables.get(i).color);
			g.drawPolygon(drawables.get(i).polygon);
		}
		
		if(tutorial) drawTutorial(g);
	}
	
	private void drawTutorial(Graphics g) {
		g.setColor(new Color(0f, 0.5f, 0.5f));
		g.setFont(new Font(Font.MONOSPACED, 5, 12));
		g.drawString("Click to add points to the current polygon.", 5, 15);
		g.drawString("Press enter to complete the polygon and start the next.", 5, 30);
		g.drawString("Press F1 to show and hide this tutorial.", 5, 45);
		g.drawString("Press Backspace to either go back to the previous polygon(After hitting enter), or to delete the current one.", 5, 60);
		g.drawString("Press C to open the color chooser.", 5, 75);
		
	}
	
}