import java.util.concurrent.ForkJoinPool;

/**
 * @author kerain.z
 * @date 2018/3/12
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        System.out.printf("%d",ForkJoinPool.commonPool().getParallelism());
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}
