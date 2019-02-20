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
    private int catacity = 5;
    private Queue<Baozi> repository = new ArrayBlockingQueue<>(10);

    //private Queue<Consumer> consumers = new ArrayBlockingQueue<>(20);

    /**
     * 自己人做包子
     */
    private Supplier<Baozi> baoziSupplier = Baozi::new;

    private Object consumerLockObject = new Object();
    private Object productLockObject = new Object();

    private Thread productThread = new Thread(() -> {

        make();

    }, "生产者");

    private void make(){
        while (true) {
            try {
                //x秒一个
                Thread.sleep(500);
                synchronized (productLockObject) {
                    //System.out.println(this);
                    while (repository.size() == catacity){
                        Printer.println("包子满了");
                        productLockObject.wait();
                    }
                    Baozi baozi = baoziSupplier.get();
                    repository.offer(baozi);
                    Printer.println("做了个包子" + baozi);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private Thread seller = new Thread(()->{
       while(true){
           synchronized (consumerLockObject){
               if (!repository.isEmpty()){
                   consumerLockObject.notify();
               }
           }
           synchronized (productLockObject) {
               if (repository.size() != catacity){
                   productLockObject.notify();
               }
           }
           try {
               Thread.sleep(100L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    },"seller");





    /**
     * 卖包子
     */
    public void sell(Consumer<Baozi> consumer) throws InterruptedException {
        synchronized (consumerLockObject) {
            while (repository.isEmpty()){
                Printer.println("没包子了,稍等");
                consumerLockObject.wait();
            }
            Baozi baozi = repository.poll();
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
        this.seller.start();

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
                    Printer.println("消费者" + consumerIndex + "去买包子" );
                    baoziStore.sell(baozi -> Printer.println("消费者" + consumerIndex + "买到了包子" + baozi));
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
