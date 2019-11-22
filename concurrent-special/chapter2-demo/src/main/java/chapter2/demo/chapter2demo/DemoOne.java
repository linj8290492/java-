package chapter2.demo.chapter2demo;

/**
 * @author deke
 * @description xx
 * @date 2019/11/21
 */
public class DemoOne {

//    public static boolean stop = false;//不会结束
    public volatile static boolean stop = false;//会结束


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            int i = 0;
            while (!stop){
                i++;
            }
        });
        thread.start();
        Thread.sleep(1000);
        stop=true;//这边修改为true，并不能终止以上的线程
    }
}
