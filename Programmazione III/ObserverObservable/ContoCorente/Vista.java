package ContoCorente;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class Vista extends JFrame implements Observer {
	JLabel display;
	ContoBancario cb;
	Vista(ContoBancario conto){
		cb=conto;
		display=new JLabel();
		add(display);
		display.setText("Saldo: "+0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void update(Observable ob,Object extra){
		display.setText("saldo: "+((ContoBancario)ob).getSaldo());
	}
	public static void main(String[]args){
		ContoBancario cb=new ContoBancario();
		Vista v = new Vista(cb);
		Versa versa = new Versa(cb);
		cb.addObserver(v);
	}
}
class Versa extends JFrame implements ActionListener
{  private JButton button;
   private JTextField inputVal;
   private JPanel panel;
   private ContoBancario cb;

   public Versa(ContoBancario conto)
   {  cb = conto;
      button = new JButton("Versa");
      inputVal = new JTextField("0", 8);
      panel = new JPanel();
      panel.add(button);
      add(panel);
      panel.add(inputVal);
      button.addActionListener(this);
      inputVal.addActionListener(this);
      setLocation(50,50);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);

   }

   public void actionPerformed(ActionEvent e)
   {  int val = Integer.parseInt(inputVal.getText());
      cb.versamento(val);
   }
}
