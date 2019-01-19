package com.syh.strings;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 19-1-20
 * Time: 上午2:17
 * To change this template use File | Settings | File Templates.
 *
 * https://leetcode.com/problems/integer-to-roman/submissions/
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman zzc = new IntegerToRoman();

        //System.out.println(zzc.intToRoman(3));
        //System.out.println(zzc.intToRoman(4));
        //System.out.println(zzc.intToRoman(9));
        // System.out.println(zzc.intToRoman(10));
        // System.out.println(zzc.intToRoman(58));
        System.out.println(zzc.intToRoman(1994));
    }

    String str_1 = "I";
    String str_5 = "V";
    String str_10 = "X";
    String str_50 = "L";
    String str_100 = "C";
    String str_500 = "D";
    String str_1000 = "M";
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        doIntToRoman(num, sb);

        return sb.toString();
    }

    public void doIntToRoman(int num, StringBuilder sb){
        if(num <=0){
            return;
        }

        int weishu = String.valueOf(num).length();
        int wei10 = 1;
        for(int i=0; i<weishu-1; i++){
            wei10 *= 10;
        }

        int preNum = num / wei10;
        if(preNum == 4){
            if(wei10 == 1){
                sb.append(str_1+str_5);
                return ;
            }
            else if(wei10 == 10){
                sb.append(str_10+str_50);
            }
            else if(wei10 == 100){
                sb.append(str_100+str_500);
            }
        }
        else if(preNum == 9){
            if(wei10 == 1){
                sb.append(str_1+str_10);
                return ;
            }
            else if(wei10 == 10){
                sb.append(str_10+str_100);
            }
            else if(wei10 == 100){
                sb.append(str_100+str_1000);
            }
        }
        else if(preNum>=1 && preNum<4){
            if(wei10 == 1){
                for(int i=0; i<preNum; i++){
                    sb.append(str_1);
                }
                return ;
            }
            else if(wei10 == 10){
                for(int i=0; i<preNum; i++){
                    sb.append(str_10);
                }
            }
            else if(wei10 == 100){
                for(int i=0; i<preNum; i++){
                    sb.append(str_100);
                }
            }
            else if(wei10 == 1000){
                for(int i=0; i<preNum; i++){
                    sb.append(str_1000);
                }
            }
        }
        else if(preNum>=6 && preNum<=8){
            if(wei10 == 1){
                sb.append(str_5);
                for(int i=0; i<preNum-5; i++){
                    sb.append(str_1);
                }
                return ;
            }
            else if(wei10 == 10){
                sb.append(str_50);
                for(int i=0; i<preNum-5; i++){
                    sb.append(str_10);
                }
            }
            else if(wei10 == 100){
                sb.append(str_500);
                for(int i=0; i<preNum-5; i++){
                    sb.append(str_100);
                }
            }
        }
        else if(preNum==5){
            if(wei10 == 1){
                sb.append(str_5);
                return ;
            }
            else if(wei10 == 10){
                sb.append(str_50);
            }
            else if(wei10 == 100){
                sb.append(str_500);
            }
        }

        int newNum = num - (preNum*wei10);
        doIntToRoman(newNum, sb);
    }
}
