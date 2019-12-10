package chapter7.demo.chapter7demo.blocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author deke
 * @description xx
 * @date 2019/12/9
 */
public class BlockingDemo {

    ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(10);

    {
        init();
    }

    public void init() {
        new Thread(() -> {
            while (true) {
                try {
                    String data = abq.take();
                    System.out.println("I'm take:" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void add(String data) throws InterruptedException {
        abq.add(data);
        System.out.println("I'm add:" + data);
        Thread.sleep(500);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingDemo bk = new BlockingDemo();
        for (int i = 0; i < 100; i++) {

            bk.add("data:" + i);
        }
    }
}
