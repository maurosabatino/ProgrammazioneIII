package ContoCorrente;

 class BankTestSynchr
{  public static void main(String[] args)
   {  Bank b = new Bank(10, 10);
      for (int i=0; i < 10; i++)
         new TransferThread(b,1000).start();
   }
}


class BankAccount
{
   private int balance;

   public synchronized void deposit(int amount)
   {  int temp = balance;
      temp = temp + amount;
      balance = temp;
      notifyAll();
   }

   public synchronized void withdraw(int amount)
   {  while (amount > balance)
         try {wait();} catch (InterruptedException e){}
      int temp = balance;
      try {
         Thread.sleep(1);
          } catch(InterruptedException e) {}
      temp = temp - amount;
      balance = temp;
   }

   public int getBalance()
   {  return balance;
   }
}

class Bank
{  private BankAccount[] accounts;

   Bank(int nacc, int init)
   {  accounts = new BankAccount[nacc];
      for (int i=0; i<nacc; i++)
         {  accounts[i] = new BankAccount();
            accounts[i].deposit(init);
         }
   }

   public void transfer(int from, int to, int amount)
   {  System.out.print(Thread.currentThread().getName() + "   ");
   	
   	System.out.println("trasferimento da " + from + " a " + to +
                        " di " + amount);
      accounts[from].withdraw(amount);
      System.out.println("ritirati da " + from + " " + amount);
      accounts[to].deposit(amount);
      System.out.println("versati a " + to + " " + amount);
      printTotal();
   }

   public int size()
   {  return accounts.length;
   }

   public void printTotal()
   {  int sum = 0;
      for (int i=0; i < accounts.length; i++){
    	  sum = sum + accounts[i].getBalance();
    	  System.out.println("balance:"+accounts[i].getBalance()+"del conto:"+i);
      }
        
      System.out.println("totale: "+sum);
   }
}

class TransferThread extends Thread
{  private Bank bank;
   private int maxAmount;

   public TransferThread(Bank b, int max)
   {  bank = b;
      maxAmount = max;
   }

   public void run()
   {
         int from = (int)(bank.size() * Math.random());
         int to = (int)(bank.size() * Math.random());
         int amount = (int)(maxAmount * Math.random());
         bank.transfer(from,to,5);

   }
}