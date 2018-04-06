package com.drew.test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthButtonAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("South Button pushed!");
		Object source = e.getSource();
		System.out.println(source);
	}
	
}
