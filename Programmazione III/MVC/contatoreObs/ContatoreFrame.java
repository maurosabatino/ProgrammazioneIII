package contatoreObs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContatoreFrame extends JFrame {
	public ContatoreFrame(){
		Counter contatore=new Counter(0);
		View contatoreView = new View(contatore);
		contatore.addObserver(contatoreView);
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(contatoreView,BorderLayout.CENTER);
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
