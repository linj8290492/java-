package chapter8.demo.chapter8demo.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author deke
 * @description Callable
 * @date 2019/12/12
 */
public class FutureDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("execute:call");
        Thread.sleep(5000);
        return "hello call";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureDemo futureDemo = new FutureDemo();
        FutureTask<String> stringFutureTask = new FutureTask<String>(futureDemo);
        new Thread(stringFutureTask).start();
        //阻塞式获取结果，上面在sleep 5 sec
        System.out.println(stringFutureTask.get());
    }
}
