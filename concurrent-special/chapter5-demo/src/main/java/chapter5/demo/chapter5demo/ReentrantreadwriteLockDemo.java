package chapter5.demo.chapter5demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author deke
 * @description 读写锁demo
 * @date 2019/11/27
 */
public class ReentrantreadwriteLockDemo {

    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    //获得读锁
    static Lock rl = rwl.readLock();
    //获得写锁
    static Lock wl = rwl.writeLock();

    //模拟缓存
    static Map<String, Object> cacheMap = new HashMap<>(16);

    /**
     * 有2个线程，分别是线程A和线程B请求过来，线程A先获得了一个写锁，那么线程B就会被阻塞，直到线程A锁释放
     * 有2个线程，分别是线程A和线程B请求过来，线程A先获得了一个读锁，那么线程B就不会被阻塞，
     * 读->读 不阻塞
     * 读->写 阻塞
     * 写->写 阻塞
     */


    public static final Object get(String key) {
        System.out.println("begin read data: " + key);
        rl.lock();

        try {
            return cacheMap.get(key);
        } finally {
            rl.unlock();
        }
    }

    public static final Object put(String key, Object val) {
        System.out.println("begin write key: " + key + ",val: " + val);
        wl.lock();
        try {
            return cacheMap.put(key, val);
        } finally {
            wl.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            put("key1","val1");
        });
        Thread t2 = new Thread(()->{
            get("key1");
        });
        /******************读写互斥********************/
        t2.start();
        t1.start();

    }


}
