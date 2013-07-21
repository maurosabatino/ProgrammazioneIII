package contatoreObs;

import java.util.*;

public class Counter extends Observable {
	int c;
	public Counter(int n){
		c=n;
		setChanged();
		notifyObservers();
	}
	public void init(int n){
		c=n;
		setChanged();
		notifyObservers();
	}
	public void incr(){
		c++;
		setChanged();
		notifyObservers();
	}
	public void decr(){
		c--;
		setChanged();
		notifyObservers();
	}
	int getVal(){
		return c;
	}
	
}
