package produttoriConsumatori;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        ProducerTest p1 = new ProducerTest(c, 1);
        ConsumerTest c1 = new ConsumerTest(c, 1);

        p1.start();
        c1.start();

    }
}

class ProducerTest extends Thread {
    private CubbyHole cubbyhole;
    private int number;

    public ProducerTest(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            cubbyhole.put(i);
            System.out.println("Producer #" + this.number
                               + " put: " + i);
            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) { }
        }
    }
}

class ConsumerTest extends Thread {
    private CubbyHole cubbyhole;
    private int number;

    public ConsumerTest(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = cubbyhole.get();
            System.out.println("Consumer #" + this.number
                               + " got: " + value);
            try {
                sleep((int)(Math.random() * 10));
            } catch (InterruptedException e) { }
        }
    }
}

class CubbyHole {
    private int contents;
    private boolean available = false;

    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        available = false;
        notifyAll();
        return contents;
    }

    public synchronized void put(int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}