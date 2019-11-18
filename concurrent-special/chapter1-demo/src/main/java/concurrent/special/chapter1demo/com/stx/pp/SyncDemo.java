package concurrent.special.chapter1demo.com.stx.pp;

/**
 * @author deke
 * @description synchronized的基本使用
 * 2种代码表现形式
 * 2种作用范围（对象锁/类锁）
 * 对象锁和类锁的区别：是否跨对象跨线程被保护
 * @date 2019/11/18
 */
public class SyncDemo {

    //1. 修饰实例方法（对象锁）
    public synchronized void demo(){

    }

    //2. 修饰代码块
    public void demo2(){
       //TODO:
        synchronized(this){

        }
        //TODO:
    }

    //3. 修饰静态方法
    public synchronized static void demo3(){

    }

    //和3类似
    public void demo4(){
        synchronized (SyncDemo.class){

        }
    }

}
