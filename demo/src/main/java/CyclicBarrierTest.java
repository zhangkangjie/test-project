import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        System.out.println("barrier action");
    });
    public static void main(String[] args) {
        for (int i =1;i<=5;i++ ){
            new Thread(new Runner(i)).start();
        }



    }

    private static class Runner implements Runnable {
        public Runner(int id){
            this.id = id;
        }
        private int id;
        @Override
        public void run() {
            System.out.println(this.id+" run...");
            try {
                Thread.sleep(1000);
                System.out.println("before "+this.id+" do await,the waiting num is "+barrier.getNumberWaiting()+", barrier broken state is "+barrier.isBroken());
                barrier.await();
                if(barrier.isBroken()){
                    System.out.println(" the waiting num is "+barrier.getNumberWaiting()+", barrier is broken");
                }
                System.out.println(this.id +" await stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

}
