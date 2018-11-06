package com.daniel.awtgraphics.main;

import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

import com.daniel.awtgraphics.objects.Drawable;
import com.daniel.awtgraphics.panel.DrawingPanel;
import com.daniel.awtgraphics.popups.ColorChooser;

public class AWTGraphicsMain extends JFrame {
	
	DrawingPanel panel;
	
	ArrayList<Integer> xvals = new ArrayList<Integer>();
	ArrayList<Integer> yvals = new ArrayList<Integer>();
	
	Dimension mouseLocation = new Dimension(0, 0);
	
	ColorChooser colorChooser = new ColorChooser();

	public static void main(String[] args) {
		new AWTGraphicsMain();
	}
	
	private AWTGraphicsMain() {
		panel = new DrawingPanel();
		this.setSize(new Dimension(800, 800));
		this.setVisible(true);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Epic Polygon Drawer MK I");
		panel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent event) {
				
			}

			@Override
			public void mouseEntered(MouseEvent event) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent event) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent event) {
				if(panel.drawables.size() == 0) panel.drawables.add(new Drawable());
				xvals.add(event.getX());
				yvals.add(event.getY());
				panel.drawables.set(panel.drawables.size() - 1, new Drawable(new Polygon(getXAndYVals()[0], getXAndYVals()[1], xvals.size()), colorChooser.getSelectedColor()));
				panel.repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent event) {
				
			}
			
		});
		panel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent event) {
				
				
			}

			@Override
			public void mouseMoved(MouseEvent event) {
				
			}
		
		});
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent event) {
				if(event.getKeyCode() == 10) {
					panel.drawables.add(new Drawable());
					xvals = new ArrayList<Integer>();
					yvals = new ArrayList<Integer>();
				} else if(event.getKeyCode() == 112) {
					panel.tutorial = !panel.tutorial;
				} else if(event.getKeyCode() == 8) {
					panel.drawables.remove(panel.drawables.size() - 1);
					xvals = new ArrayList<Integer>();
					yvals = new ArrayList<Integer>();
					if(panel.drawables.size() != 0) {
						xvals.addAll(Arrays.asList(toPrimitiveArray(panel.drawables.get(panel.drawables.size() - 1).polygon.xpoints)));
						yvals.addAll(Arrays.asList(toPrimitiveArray(panel.drawables.get(panel.drawables.size() - 1).polygon.ypoints)));
					}
				} else if(event.getKeyCode() == 67) {
					colorChooser.setVisible(true);
				}
				panel.repaint();
				System.out.println(event.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent event) {
				
			}

			@Override
			public void keyTyped(KeyEvent event) {
					
			}
		
		});
	}
	
	private int[][] getXAndYVals() {
		int[] x = new int[this.xvals.size()];
		int[] y = new int[this.yvals.size()];
		for(int i = 0; i < x.length; i++) {
			x[i] = this.xvals.get(i);
			y[i] = this.yvals.get(i);
		}
		int[][] returnVal = {x, y};
		return returnVal;
	}
	
	private Integer[] toPrimitiveArray(int[] ints) {
		Integer[] returnVal = new Integer[ints.length];
		for(int i = 0; i < ints.length; i++) returnVal[i] = (Integer) ints[i];
		return returnVal;
	}

}
