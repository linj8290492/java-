package chapter2.demo.chapter2demo;

/**
 * @author deke
 * @description 锁规则
 * @date 2019/11/23
 */
public class SyncDemo {
    private static Object lock= new Object();
    public static void demo(String str){
        synchronized (lock){
            System.out.println(str+"aaa");
        }
    }

    public static void main(String[] args) {
        demo("1");
        demo("2");

    }

}
