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
     * 中文小写 计数单位
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
        return convert(num,1);
    }
    public static String convertcapitalChineseDigtal(long num){
        return convert(num,2);
    }


    /**
     *
     */
    public static String convert(long num,int type){
        char[] targetDigtal;
        char[] targetUnit;
        if (type == 1) {
            //小写
            targetDigtal = lowerCaseDigtal;
            targetUnit = lowerCaseUnit;
        }else {
            //大写
            targetDigtal = capitalsDigtal;
            targetUnit = capitalUnit;
        }

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
                }else if(count>4){
                    ui = count%4;
                }else {
                    ui = count;
                }

                //0 后 不用带计数单位
                if (c != '0') {
                    arr[2*i+1] = targetUnit[ui];
                }
            }
        }
        // '一十' 省略为 ’十‘
        String str = String.valueOf(arr);
        str = str.replaceAll("一十","十");
        str = str.replaceAll("零\u0000零\u0000","零");
        str = str.replaceAll("壹拾","拾");


        System.out.println(num);
        return str;
    }

    public static void main(String[] args) {

        System.out.println( convertLowerChineseDigtal(Integer.MAX_VALUE) );
        System.out.println( convertcapitalChineseDigtal(Integer.MAX_VALUE) );


    }


}
