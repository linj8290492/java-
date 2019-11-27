package chapter5.demo.chapter5demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author deke
 * @description ReentrantLock重入锁的体现
 * @date 2019/11/27
 */
public class ReentrantLockDemo {

    static Lock lock = new ReentrantLock();

    public static void demo(String str) {
        System.out.println(str + "aaa");
    }

    public static void main(String[] args) {
        lock.lock();//获得锁

        demo("111");
        demo("22");

        lock.unlock();//释放锁

    }
}
