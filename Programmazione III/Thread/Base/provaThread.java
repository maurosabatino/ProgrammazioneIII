package Base;

public class provaThread extends Thread{
	public void run(){
		System.out.println("sono il thread:     "+getName());
	}
	public static void main(String[] args){
		for(int i=0;i<10;i++){
			provaThread t = new provaThread();
			t.start();
		}
	}
}
