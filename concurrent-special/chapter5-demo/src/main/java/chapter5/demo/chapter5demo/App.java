package chapter5.demo.chapter5demo;

/**
 * @author deke
 * @description synchronized重入锁的体现
 * @date 2019/11/27
 */
public class App {

    public synchronized void demo(){ //main获得对象锁
        System.out.println("demo");
        demo2();
    }

    public void demo2() {
        synchronized(this){ // 再次获得对象锁，增加重入次数就可以了，假如没有重入锁的体现，那么此处是不是就会发生死锁了
            System.out.println("demo2");
        }//结束后减少重入次数
    }

    public static void main(String[] args) {
        App app = new App();
        app.demo();

    }
}
