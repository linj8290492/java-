package concurrent.special.chapter1demo.com.stx.pp;

/**
 * @author deke
 * @description 线程B负责唤醒线程A
 * @date 2019/11/20
 */
public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock){
            System.out.println("start ThreadB");
            lock.notify();
            System.out.println("end ThreadB");
        }
    }
}
