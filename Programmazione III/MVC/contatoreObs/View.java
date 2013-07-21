package contatoreObs;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class View extends JPanel implements CounterInterfaceView, Observer   {
	 private Counter contatore;
	 private JLabel label;
	 private CounterControl controller;
	
	 public View(Counter model){
		 super(new BorderLayout());
		 label = new JLabel("valore contatore: ");
		 JPanel panelCenter = new JPanel (new FlowLayout());
		 panelCenter.add(label);
		 add(panelCenter,BorderLayout.CENTER);
		 JPanel panelSouth = new JPanel(new FlowLayout());
		 contatore= model;
		 controller = new CounterControl(contatore);
		 JButton bottoneDecr = new JButton("decrementa");
		 bottoneDecr.addActionListener(controller);
		 panelSouth.add(bottoneDecr);
		 JButton reset = new JButton("reset");
		 reset.addActionListener(controller);
		 panelSouth.add(reset);
		 JButton bottoneIncr = new JButton("incrementa");
		 bottoneIncr.addActionListener(controller);
		 panelSouth.add(bottoneIncr);
		 add(panelSouth,BorderLayout.SOUTH);
	 }


	 public void updateView(){
		 label.setText("Valore contatore: " +contatore.getVal());
	 }
	@Override
	public void update(Observable ob, Object extra_arg) {
		updateView();
		
	}
	 


}
