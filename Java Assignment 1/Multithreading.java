public class Multithreading {
    public static void main(String[] args) {
        Thread t1 = new Thread(new first());
        Thread t2 = new Thread(new second());
        Thread t3 = new Thread(new third());
        t1.start();
        t2.start();
        t3.start();
    }
}
class first implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("First class: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class second implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i < 15; i++) {
            System.out.println("Second class: " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class third implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i < 25; i++) {
            System.out.println("Third class: " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
