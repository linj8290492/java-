package chapter8.demo.chapter8demo.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author deke
 * @description 固定线程数的线程池
 * @date 2019/12/10
 */
public class FixedThreadPoolDemo implements Runnable {

    static ExecutorService service = Executors.newFixedThreadPool(3);

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            service.execute(new FixedThreadPoolDemo());
        }
        service.shutdown();
    }

}
