package counter;

import org.apache.commons.lang.math.RandomUtils;

public class CounterTest {
    public static void main(String[] args) {
        Thread statThread = new Thread(new StatData());
        Thread invokeThread = new Thread(()->{
            InvokeCounter invokeCount = new InvokeCounter();
            while (true){
                try {
                    Thread.sleep(RandomUtils.nextInt(10));
                    //Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                invokeCount.hit();
            }

        });
        statThread.start();
        invokeThread.start();

        while (true){
            System.out.printf("%d  %d  %d  %s  %d \n",StatData.last10SecondsAverage,StatData.last10MinsAverage,
                    StatData.last60MinsAverage,StatData.last60SecondsCount,StatData.queue.size());
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
