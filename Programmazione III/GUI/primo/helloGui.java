package primo;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class helloGui extends JFrame {
	
	helloGui(){
		Panel panel = new Panel();
		getContentPane().add(panel);
		
		addWindowListener(new WL());
		setSize(800, 600);
		setVisible(true);
	}
	public class Panel extends JPanel{
		ButtonBeep panelBeep = new ButtonBeep();
		ButtonColor panelColor = new ButtonColor();
		Panel(){
		add(panelBeep);
		add(panelColor);
		}
	}
	public class ButtonBeep extends JPanel{
		
		ButtonBeep(){
			JButton button = new JButton("click me");
			add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Toolkit.getDefaultToolkit().beep();
				}
			});
			
		}
		
	}
	public class ButtonColor extends JPanel implements ActionListener{
		
		ButtonColor(){
			
			JButton yellowButton = new JButton("yellow");
			JButton blueButton = new JButton("blue");
			JButton redButton = new JButton("red");
			add(yellowButton);
			add(blueButton);
			add(redButton);
			yellowButton.addActionListener(this);
			blueButton.addActionListener(this);
			redButton.addActionListener(this);
			
		}
		public void actionPerformed(ActionEvent e){
			String comand = e.getActionCommand();
			if(comand.equals("yellow")) setBackground(Color.yellow);
			else if(comand.equals("blue")) setBackground(Color.BLUE);
			else if(comand.equals("red")) setBackground(Color.red);
		}
	}
	
	
	
	public static void main(String [] args){
		helloGui finestrela = new helloGui();
	}
	
	class WL extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
}
