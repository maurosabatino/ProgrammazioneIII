package contatore;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ContatoreFrame extends JFrame{
	Counter counter;
	View view;
	public ContatoreFrame(){
		counter = new Counter();
		view=new View(counter);
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(view,BorderLayout.CENTER);
		cp.add(new ExitButton(),BorderLayout.SOUTH);
		addWindowListener(new ExitFrame());
		setSize(300,140);
		setVisible(true);
		
	}
	
	public static void main(String[]args){
		ContatoreFrame contatore= new ContatoreFrame();
	}
}
class ExitFrame extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}

class ExitButton extends JButton implements ActionListener{
	public ExitButton(){
		super("Exit");
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
}
