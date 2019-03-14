package counter;

public class InvokeCounter implements ICounter {


    @Override
    public void hit() {
        StatData.queue.offer(System.currentTimeMillis());
    }


}
