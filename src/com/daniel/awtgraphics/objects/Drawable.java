package com.daniel.awtgraphics.objects;

import java.awt.Color;
import java.awt.Polygon;

public class Drawable {
	
	public Polygon polygon = new Polygon();
	public Color color;
	
	public Drawable(Polygon polygon, Color color) {
		this.polygon = polygon;
		this.color = color;
	}
	
	public Drawable() {
		
	}
}
