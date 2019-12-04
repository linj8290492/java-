package chapter6.demo.chapter6demo.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author deke
 * @description 使多线程同时唤醒
 * @date 2019/12/3
 */
public class ConditionNotify implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("begin-------------ConditionNotify");
            condition.signal();
            System.out.println("end-------------ConditionNotify");
        } finally {
            lock.unlock();
        }
    }
}
