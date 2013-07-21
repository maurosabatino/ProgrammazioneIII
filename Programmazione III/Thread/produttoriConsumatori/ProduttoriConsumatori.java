package produttoriConsumatori;

public class ProduttoriConsumatori {
public static void main(String[] args){
	Negozio neg=new Negozio();
	Producer p=new Producer(neg,1);
	Consumer c=new Consumer(neg,1);
	p.start();
	c.start();
}
}

class Producer extends Thread {
	private Negozio negozio;
	private int n;
	public Producer(Negozio neg,int n){
		negozio=neg;
		this.n=n;
	}
	public void run(){
		for(int i=0; i<10;i++){
			negozio.put(i);
			System.out.println("il produttore:"+this.n+" ha prodotto"+i);
			try{sleep(1000);}
			catch(InterruptedException e){}
		}
	}
}

class Consumer extends Thread{
	private Negozio negozio;
	private int n;
	Consumer(Negozio neg,int n){
		negozio=neg;
		this.n=n;
	}
	public void run(){
		int value;
		for(int i=0; i<10;i++){
			value=negozio.get();
			System.out.println("il consumatore:"+this.n+" ha preso"+value);
			try{sleep(10);}
			catch(InterruptedException e){}
		}
	}
}

class Negozio{
	private int contenuto;
	private boolean disponibile = false;
	
	public synchronized int get(){
		while(disponibile==false){
			try{wait();}
		catch (InterruptedException e){}
		}
			disponibile = false;
			notifyAll();
			return contenuto;
	}
	public synchronized void put(int val){
		while(disponibile==true){
			try{wait();}
			catch (InterruptedException e){}
		}
		contenuto=val;
			disponibile=true;
			notifyAll();
	}
}