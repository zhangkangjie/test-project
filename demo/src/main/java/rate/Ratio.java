package rate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;



public class Ratio {

    public static void main(String[] args) {


//        p("0.8",100,true,true);


    }

    public static void p(String rateStr,int loopTimes, boolean enableBalance,boolean enableProbability){
        BigDecimal rate = new BigDecimal(rateStr);
//        System.out.println("tryTimes \t hitTimes \t actualRate");
        for (int i = 1; i <= loopTimes; i++) {
            int hitTimes = 0;
            int tryTimes =0;
            BigDecimal accumulateValue = BigDecimal.ZERO;
            for (int j = 1; j <= i; j++) {
                tryTimes++;
                accumulateValue = accumulateValue.add(rate);
                int x = rate.multiply(new BigDecimal(100)).intValue();
                boolean probability = probability(x);

                //b
                if (enableBalance && !enableProbability &&  accumulateValue.compareTo(BigDecimal.ONE)>0){
                    accumulateValue = accumulateValue.subtract(BigDecimal.ONE);
                    hitTimes++;
                    continue;
                }
                //p
                if (enableProbability && !enableBalance && probability){
                    hitTimes++;
                    accumulateValue = accumulateValue.subtract(BigDecimal.ONE);
                    continue;
                }
                //bp
                if (enableProbability && enableBalance){
                    boolean bp1 = (accumulateValue.compareTo(new BigDecimal(1))>0 );
                    boolean bp2 = (probability && accumulateValue.subtract(BigDecimal.ONE).compareTo(new BigDecimal(-1))>0 );
                    if (bp1 || bp2){
                        hitTimes++;
                        accumulateValue = accumulateValue.subtract(BigDecimal.ONE);
                        continue;
                    }
                }

            }
            String actualRate = new BigDecimal(hitTimes).divide(new BigDecimal(tryTimes), 4, RoundingMode.HALF_UP).toString();
//            System.out.printf("%s \t %s \t %s\n",i,hitTimes,actualRate);
            System.out.println(actualRate);
        }
    }


    public static boolean probability(int x) {
        return new Random().nextInt(100) < x;
    }




}
