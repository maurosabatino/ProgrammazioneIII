package contatore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// L'esecuzione del ciclo infinito del listener
// del bottone START viene fatta in un nuovo thread
// Questo fa si' che il thread dell'interfaccia grafica
// possa servire altri eventi

public class ContConThread extends JFrame
{  private int count = 0;
   private JButton onOff = new JButton("ON-OFF");
   private JButton start = new JButton("START");
   private JTextField t = new JTextField(4);
   private boolean runFlag = true;
   private ThreadCont tc = new ThreadCont();

   public ContConThread()
   {  Container cp = getContentPane();
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

   class ThreadCont extends Thread
   {  public void run()
      {  while (true)
         {  try
            {  Thread.sleep(500);
            } catch(InterruptedException exc) {}
            if (runFlag) t.setText(Integer.toString(count++));
            else t.setText(Integer.toString(count--));
            System.out.println(getName());
         }
      }
   }

   class OnOffL implements ActionListener
   {  public void actionPerformed(ActionEvent e)
      {  runFlag = !runFlag;
         System.out.println(Thread.currentThread().getName());
      }
   }

   class StartL implements ActionListener
   {  public void actionPerformed(ActionEvent e)
      {  tc.start();
      }
   }



   public static void main(String args[])
   {   ContConThread f = new ContConThread();

   }
}