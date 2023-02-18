package rate;

import org.springframework.data.redis.support.atomic.RedisAtomicDouble;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 按比例配比
 * @author kangjie.zhang@ttpai.cn
 * @date 2023/2/18
 */
public class RatioUtil {

    /**
     *
     * 复合概率配比合队列配比，并设定上下限，使配比尽可能接近预期值。
     * 相比较减少了概率随机性过高稳定差的缺点，减少了队列配比中的固定偏差值。
     *
     * @param ratio
     * @param atomicDouble
     * @return
     */
    public static boolean complexRatio(double ratio, RedisAtomicDouble atomicDouble) {
        double v = atomicDouble.addAndGet(ratio);
        boolean bp1 = v >= 1;
        boolean probability = ratioByProbability(ratio);
        boolean bp2 = (probability && v > 0);
        if (bp1 || bp2) {
            //累积值 -1
            atomicDouble.decrementAndGet();
            return true;
        }
        return false;
    }


    /**
     * 队列配比，每多少个必出现一个，如：配比值0.1 每十个命中一个
     * @param ratio 配比值
     * @param atomicDouble
     * @return
     */
    public static boolean ratioByLine(double ratio, RedisAtomicDouble atomicDouble) {
        double v = atomicDouble.addAndGet(ratio);
        if (v >= 1) {
            //累积值 -1
            atomicDouble.decrementAndGet();
            return true;
        }
        return false;
    }

    /**
     * 按概率配比
     *
     * @param rate [0,1] 限两位小数如 0.12
     * @return 是否命中
     */
    public static boolean ratioByProbability(double rate) {
        int x = new BigDecimal(String.valueOf(rate)).multiply(new BigDecimal(100)).intValue();
        return new Random().nextInt(100) < x;
    }


}
