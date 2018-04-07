package com.drew.test1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	public KeyInput() {
		System.out.println("KeyInput created.");
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		System.out.println("Pressed");
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_A) {
			System.out.println("A Released");
		}
	}
	
	public void keyTyped(KeyEvent e) {
		char char1 = e.getKeyChar();
		System.out.println("You typed "+char1+" character on the keyboard.");
	}
	
}
