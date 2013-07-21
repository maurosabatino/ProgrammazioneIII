package contatore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Il contatore viene incrementato o decrementato
// a seconda del valore di runFlag
// Il bottone puo'  cambiare il valore di runFlag
// anche se il main sta eseguendo una computazione infinita

public class Contatore2
{
	private static boolean runFlag = true;


	public static void main(String[] argv)
	{	JButton onOff = new JButton("ON-OFF");
	  	JTextField t = new JTextField(4);
	 	JFrame f = new JFrame();
	 	int count = 0;

		Container cp = f.getContentPane();
		cp.setLayout(new FlowLayout());
		onOff.addActionListener(new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{	runFlag = !runFlag;
				}
			});
		cp.add(onOff);
		cp.add(t);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
      f.setVisible(true);

		// il main entra in un ciclo infinito
      while (true)
		{	try
			{	Thread.sleep(500);
			} catch(InterruptedException e) {}
			if (runFlag) t.setText(Integer.toString(count++));
			else t.setText(Integer.toString(count--));
		}

	}
}