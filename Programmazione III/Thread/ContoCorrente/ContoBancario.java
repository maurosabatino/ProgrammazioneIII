package ContoCorrente;

public class ContoBancario {
	private int saldo=0;
	private boolean disponibile=false;
	public synchronized void prelievo(int val) throws InterruptedException{
		while(disponibile==false){
			wait();
		}
		while(val>saldo)
			wait();
		disponibile=false;
		notifyAll();
		saldo-=val;
	}
	public synchronized void versamento(int val){
		while(disponibile==true){
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		saldo+=val;
		disponibile=true;
		notifyAll();
	}
	public int getSaldo(){
		return saldo;
	}
	public static void main(String[]args) throws InterruptedException{
		ContoBancario cb=new ContoBancario();
		for(int i=0;i<10;i++){
		 new Versamento(cb,20,15).start();
			
		}
	}

}

class Versamento extends Thread{
	int versamento;
	int prelievo;
	ContoBancario cc;
	Versamento(ContoBancario cb, int v,int p){
		cc=cb;
		versamento=v;
		prelievo=p;
	}
	public void run(){
		cc.versamento(versamento);
		try {
			cc.prelievo(prelievo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("saldo attuale: "+cc.getSaldo()+""+getName());
		
	}
}
