package com.drew.test1;


/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/*
 * Beeper.java requires no other files.
 */
 
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
 
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
 
public class Beeper extends JPanel 
                    implements ActionListener, FocusListener {

    public Beeper() {
    	super(new BorderLayout());
    	this.setFocusable(true);
    	this.requestFocusInWindow();
    	JButton button = new JButton ("Button North");
        JButton btn2 = new JButton ("Button Center");
        JButton btn3 = new JButton ("Button South");
    	NorthButtonAction nbutact = new NorthButtonAction();
    	SouthButtonAction sbutact = new SouthButtonAction();   	
        button.setPreferredSize(new Dimension(200, 80));
        add(button, BorderLayout.NORTH);
        button.addActionListener(this);



        btn2.setPreferredSize(new Dimension(200,80));
        add(btn2, BorderLayout.CENTER);

//      Lambda Expression Example
        btn2.addActionListener(this);
        
        btn3.setPreferredSize(new Dimension(200,80));
        add(btn3, BorderLayout.SOUTH);

        btn3.addActionListener(this);
        btn3.addFocusListener(this);
        KeyInput ki = new KeyInput();
        addKeyListener(ki);
        
//		comment added to test laptop commit
        
//        Helper h1 = new Helper();
//        addKeyListener(h1);

//      Lambda Expression Example
//        btn3.addActionListener(new ActionListener() {
//        	
//        	public void actionPerformed(ActionEvent e){
//        		System.out.println(e);
//        	}
//
//        });
 
    }
    

    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
    	Object command = e.getActionCommand();
    	System.out.println(command);
    	if(command == "Button Center" || command == "Button North") {
    		//System.out.println("This is button center");
           	Toolkit.getDefaultToolkit().beep();
        	this.requestFocusInWindow();
    	}
//    	if(source == button) {
//    		System.out.println("This is button north");
//    	}
//    	
//    	if(source == btn3) {
//    		System.out.println("This is button south");
//    	}
    }
    
    public void focusGained(FocusEvent fe) {
    	System.out.println("Focus on south button.");
    	this.requestFocusInWindow();
    }
    
    public void focusLost(FocusEvent fe) {
    	System.out.println("Focus lost on south button");
    }
    
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Beeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new Beeper();
        
        //Create inner class instance
        Beeper beepo = new Beeper();
        Beeper.InnerHello ih = beepo.new InnerHello();
        
        
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        

    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.

    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

class InnerHello {
	InnerHello(){
		System.out.println("inner class called");
		//Ternary operator example
		int numA=5;
		int numB=990;
		int numC =(numA>numB)?numA:numB;
		System.out.println("The larger number is " + numC);
		
		//Labeled loop example
		out: for(int i=0;i<100;i++) {
				for (int j=0;j<34;j++) {
					System.out.println(i+", "+j);
					if(j==22) break;
				}
			}
			
	}
};

}
