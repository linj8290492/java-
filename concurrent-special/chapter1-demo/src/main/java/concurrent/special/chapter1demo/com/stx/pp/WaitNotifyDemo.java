package concurrent.special.chapter1demo.com.stx.pp;

/**
 * @author deke
 * @description ThreadA与ThreadB
 * @date 2019/11/20
 */
public class WaitNotifyDemo {
    public static void main(String[] args) {
        Object lock = new Object();
//        Object lock2 = new Object();

//        ThreadC threadC = new ThreadC(lock);
//        threadC.start();
        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        ThreadB threadB = new ThreadB(lock);
        threadB.start();
    }
}
