package contatore;

import java.awt.event.*;
import javax.swing.*;

public class Controller implements ActionListener{
	Counter contatore;
	ViewInterface vista;
	public Controller(Counter cont,ViewInterface view){
		contatore=cont;
		vista=view;
	}
	public void actionPerformed(ActionEvent e){
		JButton source =(JButton)e.getSource();
		if(source.getText().equals("decrementa")) contatore.decr();
		else if(source.getText().equals("incrementa")) contatore.incr();
		else contatore.init(0);
		vista.updateView();
	}
}
