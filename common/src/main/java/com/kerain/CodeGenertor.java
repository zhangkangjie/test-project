package com.kerain;

import java.util.Random;

public class CodeGenertor {


    public static void main(String[] args) {

        generate();


        long x12 =Double.valueOf(Math.pow(36+26,4)).longValue()-1;
        System.out.println(x12);
        //
        //131621703842267136
        //4738381338321616895
        System.out.println(Long.toString(x12,36));


    }

    public static String generate(){
        //timeMillis 加4 位数生成 10位36进制字符串
        Random random = new Random();
        long millis = System.currentTimeMillis();

        //prefix 1位 1-9
        String prefix = String.valueOf(random.nextInt(9)+1) ;
        //prefix 3位 100-999
        String suffix = String.valueOf(random.nextInt(900)+100) ;
        System.out.println("prefix:"+prefix);
        System.out.println("suffix:"+suffix);
        String x = prefix + millis + suffix;
        System.out.println("x: "+x);
        long y = Long.valueOf(x);
        System.out.println("y: "+Long.toString(y,36));

        return null;
    }



}
