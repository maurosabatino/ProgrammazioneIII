package ContoCorente;

import java.util.Observable;

public class ContoBancario extends Observable {
	private int saldo=0;
	public void prelievo(int n){
		saldo-=n;
		setChanged();
		notifyObservers();
	}
	public void versamento(int n){
		saldo+=n;
		setChanged();
		notifyObservers();
	}
	public int getSaldo(){
		return saldo;
	}
}
