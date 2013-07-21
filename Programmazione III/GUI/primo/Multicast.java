package primo;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Multicast {
	public static void main(String[] args){
		MulticastFrame frame = new MulticastFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class MulticastFrame extends JFrame{
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200; 
	public MulticastFrame(){
		setTitle("MulticastTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		MulticastPanel panel = new MulticastPanel();
		add(panel);
	}
}

class MulticastPanel extends JPanel{
	MulticastPanel(){
		JButton newButton = new JButton("new");
		add(newButton);
		final JButton closeButton = new JButton("close all");
		add(closeButton);
		ActionListener newListener =new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				BlankFrame frame = new BlankFrame(closeButton);
				frame.setVisible(true);
				
			}
			
		};
		newButton.addActionListener(newListener);
	}
}

class BlankFrame extends JFrame{
	private static int counter=0;
	public static final int DEFAULT_WIDTH = 200;
	public static final int DEFAULT_HEIGHT = 150;  
	public static final int SPACING = 40;
	private ActionListener closeListener;
	public BlankFrame(final JButton closeButton){
		counter++;
		setTitle("Frame " + counter);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocation(SPACING * counter, SPACING * counter);  
		closeListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closeButton.removeActionListener(closeListener);
				dispose();
			}
		};
		closeButton.addActionListener(closeListener);
	}
	
}
