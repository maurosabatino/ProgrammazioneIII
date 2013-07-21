package contatore;

public class Counter {
	int cont;
	Counter(){
		cont=0;
	}
	void incr(){
		cont++;
	}
	void decr(){
		cont--;
	}
	void init(int n){
		cont=n;
	}
	int getVal(){
		return cont;
	}
}
