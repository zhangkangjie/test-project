package thread.producerAndConsumer;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 包子铺
 */
public class BaoziStore {
    private Queue<Baozi> repository = new ArrayBlockingQueue<>(10);

    //private Queue<Consumer> consumers = new ArrayBlockingQueue<>(20);

    /**
     * 自己人做包子
     */
    private Supplier<Baozi> baoziSupplier = Baozi::new;

    private Object consumerLockObject = new Object();

    private Thread productThread = new Thread(() -> {
        //获取生产者对象锁
        synchronized (this) {
            while (true) {
                try {
                    //x秒一个
                    Thread.sleep(500);
                    Baozi baozi = baoziSupplier.get();
                    boolean b = repository.offer(baozi);
                    synchronized (consumerLockObject){
                        consumerLockObject.notify();
                    }
                    if (!b) {
                        Printer.println("包子满了");
                        //生产者wait,并释放生产者对象锁
                        this.wait();
                    } else {
                        Printer.println("做了个包子" + baozi);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }, "生产者");

//    /**
//     * 做包子
//     */
//    private void make(){
//
//        Baozi baozi = baoziSupplier.get();
//        boolean b = repository.offer(baozi);
//        if (!b){
//            System.out.println("包子装满了");
//        }else {
//            System.out.println("装个包子"+baozi);
//        }
//    }



    /**
     * 卖包子
     */
    public void sell(Consumer<Baozi> consumer) {
        synchronized (consumerLockObject) {
            Baozi baozi = repository.poll();
            if (baozi == null) {
                Printer.println("没包子了，快做");
                //TODO 死锁
                //等着有包子
                synchronized (productThread) {
                    productThread.notify();
                }
                try {
                    consumerLockObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baozi = repository.poll();
            }
            consumer.accept(baozi);
        }

    }

    /**
     * 开张
     */
    public void init() {
        Printer.println("---店铺开张---");
        //开始有人做包子
        this.productThread.start();

    }

}

class Baozi {
    private static AtomicInteger id = new AtomicInteger(0);

    public Baozi() {
        id.getAndIncrement();
    }

    @Override
    public String toString() {
        return "Baozi{" +
                "id=" + id +
                '}';
    }
}

class Setup {
    public static void main(String[] args) {
        BaoziStore baoziStore = new BaoziStore();
        baoziStore.init();

        Thread consumerThread = new Thread(() -> {
            try {
                //1-3 s 来个顾客
                for (int i = 0; i < 50; i++) {
                    Thread.sleep(RandomUtils.nextInt(3) * 1000 + 1);
                    String consumerIndex = String.valueOf(i+1);
                    baoziStore.sell(baozi -> Printer.println("消费者" + consumerIndex + "买了包子" + baozi));
                }
                Printer.println("没人了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者");

        consumerThread.start();

    }
}
class Printer {
    public static void println(String string){
        String time = DateFormatUtils.format(new Date(), "HH:MM:ss SSS");
        System.out.println(time +" : "+string);
    }
}
