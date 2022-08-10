import java.util.concurrent.locks.*;

public class Test{
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        try{
            System.out.println("Going to lock...");
            lock1.lock();
            System.out.println("Io critical section");
        }finally{
            lock2.unlock();
            System.out.println("Unlocking...");
        }
    }
}
