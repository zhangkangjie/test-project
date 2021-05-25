package com.kerain;

/**
 * 阿拉伯数字转换汉字写法
 * @author zkj
 * @date 2018/2/4
 */
public class ArabicNumConverter {

    /**
     * 中文小写数字
     */
    private static final char[] lowerCaseDigtal ={
            '零','一','二','三','四','五',
            '六','七','八','九'
    };
    /**
     * 中文小写 计数单位 权值
     */
    private static final char[] lowerCaseUnit ={
            '\u0000','十','百','千','万','亿'
    };
    private static final char[] capitalsDigtal ={
            '零','壹','贰','叁','肆','伍','陆','柒',
            '捌','玖'
    };
    /**
     * 10<sup>0</sup>
     * 10<sup>1</sup>
     * 10<sup>2</sup>
     * 10<sup>3</sup>
     * 10<sup>4</sup>
     * 10<sup>8</sup>
     *
     */
    private static final char[] capitalUnit ={
            '\u0000','拾','佰','仟','万','亿'
    };



    public static String convertLowerChineseDigtal(long num){

        return convert(num,lowerCaseDigtal,lowerCaseUnit);
    }
    public static String convertCapitalChineseDigtal(long num){

        return convert(num,capitalsDigtal,capitalUnit);
    }


    /**
     *
     */
    public static String convert(long num,char[] digtalArr,char[] unitArr){
        char[] targetDigtal = digtalArr;
        char[] targetUnit = unitArr;


        char[] numChars = String.valueOf(num).toCharArray();
        char[] arr = new char[numChars.length*2];
        for (int i = 0; i < numChars.length; i++) {
            char c = numChars[i];
            if(c == '-'){
                arr[i] = '负';
            }else {
                int v= (int)c - 48;
                arr[2*i] = targetDigtal[v];
                //arr[2*i+1] = '|';

                //倒数计数位数
                int count =numChars.length -1 - i;
                //unit index
                int ui = 0;

                if(count >=8 && count%8 == 0){
                    //亿
                    ui = 5;
                }else if(count >=4 && count%4 == 0){
                    ui = 4;
                }else {
                    ui = count%4;
                }

                //0 后 不用带计数单位
//                if (c != '0' || count%4 == 0) {
//                    arr[2*i+1] = targetUnit[ui];
//                }
                arr[2*i+1] = targetUnit[ui];
            }
        }
        // '一十' 省略为 ’十‘
        String str = String.valueOf(arr);
        str = str.replaceAll("^一十","十");
        str = str.replaceAll("(零百)?(零十)","零");
        str = str.replaceAll("([^零])零([^\u0000])","$1$2");
        str = str.replaceAll("(零\u0000)+零?","零");
        str = str.replaceAll("零$","");
        str = str.replaceAll("^壹拾","拾");


        System.out.println(num);
        return str;
    }

    public static void main(String[] args) {

        System.out.println( convertLowerChineseDigtal(Integer.MAX_VALUE) );
//        System.out.println( convertCapitalChineseDigtal(Integer.MAX_VALUE) );
//        System.out.println( convertCapitalChineseDigtal(5004520) );
//        System.out.println( convertCapitalChineseDigtal(216) );
//        System.out.println( convertLowerChineseDigtal(216) );
//        System.out.println( convertLowerChineseDigtal(2047403007) );
        System.out.println( convertLowerChineseDigtal(5004520) );
        System.out.println( convertLowerChineseDigtal(500000) );


    }


}
