package contatore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Contatore1 extends JFrame{
	private int count = 0;
	private JButton onOff = new JButton("ON-OFF");
	private JButton start = new JButton("START");
	private JTextField t = new JTextField(4);
	private boolean runFlag = true;
	public Contatore1(){
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(t);
		onOff.addActionListener(new OnOffL());
		cp.add(onOff);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.addActionListener(new StartL());
		cp.add(start);
		setSize(200,200);
		setVisible(true);

	}
	public static void main(String[]  args){
		Contatore1 contatore= new Contatore1();
	}
	
	class OnOffL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			runFlag = !runFlag;
		}
	}
	class StartL implements ActionListener{
		public void actionPerformed(ActionEvent e){
			while (true){
				try{	
					Thread.sleep(500);
				} catch(InterruptedException exc) {}
				if (runFlag) t.setText(Integer.toString(count++));
				else t.setText(Integer.toString(count--));
				System.out.println(count);
			}
		}
	}
}
