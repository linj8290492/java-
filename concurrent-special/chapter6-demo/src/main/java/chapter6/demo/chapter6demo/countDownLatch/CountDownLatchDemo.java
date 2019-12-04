package chapter6.demo.chapter6demo.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author deke
 * @description 计数器倒计时
 * @date 2019/12/4
 */
public class CountDownLatchDemo extends Thread {

    static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new CountDownLatchDemo().start();
        }
        for (int i = 0; i < 10; i++) {
            countDownLatch.countDown();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("阻塞前时间：" + System.currentTimeMillis());
            countDownLatch.await(); //在countDownLatch 没有减到0之前，这边会阻塞所有的线程
            System.out.println("阻塞后时间：" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO:等待阻塞完成后执行事件
        System.out.println("ThreadName:" + Thread.currentThread().getName());

    }
}
