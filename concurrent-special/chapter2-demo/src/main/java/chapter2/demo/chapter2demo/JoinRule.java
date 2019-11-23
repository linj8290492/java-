package chapter2.demo.chapter2demo;

/**
 * @author deke
 * @description jion规则
 * @date 2019/11/23
 */
public class JoinRule {

    static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            x=100;
        });
        t1.start();
        t1.join();//没这段join，x=0;happends-before的体现
        System.out.println(x);

    }
}
