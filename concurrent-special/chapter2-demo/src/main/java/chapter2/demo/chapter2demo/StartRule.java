package chapter2.demo.chapter2demo;

/**
 * @author deke
 * @description 启动规则(描述happends - before)
 * @date 2019/11/23
 */
public class StartRule {

    static int x = 10;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            x += 1;
            System.out.println(x);
        });
        x=10;
        t1.start();
    }

}
