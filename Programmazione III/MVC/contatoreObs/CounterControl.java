package contatoreObs;

import javax.swing.*;
import java.awt.event.*;

public class CounterControl extends JPanel implements ActionListener {
	private Counter contatore;
	CounterControl(Counter count){
		contatore=count;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source =(JButton)e.getSource();
		if(source.getText().equals("decrementa")) contatore.decr();
		else if(source.getText().equals("incrementa")) contatore.incr();
		else contatore.init(0);
		
	}

}
