package counter;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class StatData implements Runnable {

    public static Deque<Long> queue = new LinkedBlockingDeque<>();

    //最近10s平均
    public static int last10SecondsAverage;

    //最近10Min平均
    public static int last10MinsAverage;

    //最近60Min平均
    public static int last60MinsAverage;

    //最近60s计数量
    public static List<Integer> last60SecondsCount = new LinkedList<>();

    @Override
    public void run() {
        int maxExistingTimeMillis = 60 * 60 *1000;
        while (true) {
            long now = System.currentTimeMillis();
            last10SecondsAverage = calculateCount(now,10)/10;
            last10MinsAverage = calculateCount(now,600)/600;
            last60MinsAverage = calculateCount(now,3600)/3600;

            if (last60SecondsCount.size() == 60){
                last60SecondsCount.remove(0);
            }
            last60SecondsCount.add(calculateCount(now, 1));


            //remove ones that over max existing time
            Iterator<Long> iterator = queue.iterator();
            while (iterator.hasNext()){
                Long next = iterator.next();
                if (now - next >maxExistingTimeMillis){
                    iterator.remove();
                }
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param time seconds
     * @return count
     */
    private int calculateCount(long timeFrom, int time) {
        int count = 0;
        long timeMillis = time * 1000;
        Iterator<Long> iterator = queue.descendingIterator();
        while (iterator.hasNext()) {
            Long next = iterator.next();
            if (timeFrom - next >= timeMillis) {
                break;
            }else {
                count++;
            }
        }
        return count;
    }


}
