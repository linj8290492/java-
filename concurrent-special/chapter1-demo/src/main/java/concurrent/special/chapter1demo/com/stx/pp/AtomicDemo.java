package concurrent.special.chapter1demo.com.stx.pp;

/**
 * @author deke
 * @description 线程不安全的实例
 * 执行1000次，最后的count并不等于1000
 * @date 2019/11/18
 */
public class AtomicDemo {

    private static int count = 0;

    public static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->AtomicDemo.incr(),"atoThread").start();
        }
        Thread.sleep(5000);
        System.out.println("运行结果："+count);
    }
}
