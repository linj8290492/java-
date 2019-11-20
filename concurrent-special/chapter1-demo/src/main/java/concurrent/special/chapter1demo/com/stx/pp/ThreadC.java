package concurrent.special.chapter1demo.com.stx.pp;

/**
 * @author deke
 * @description 线程A负责wait
 * @date 2019/11/20
 */
public class ThreadC extends Thread {

    private Object lock;

    public ThreadC(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock){
            System.out.println("start ThreadC");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end ThreadC");
        }
    }
}
