package cn.yhd.utils;

import java.util.List;

/**
 * @author yuhuadong
 * @date 2019/9/19
 */
public class ConditionUtil {
    List<ConditionUtil> conditionUtils;
    public static void main(String[] args){
        condition1();
        condition2();
        condition3();
        condition4();
    }

    public static boolean condition1(){
        throw new RuntimeException();
    }
    public static boolean condition2(){
        throw new RuntimeException();
    }
    public static boolean condition3(){
        throw new RuntimeException();
    }
    public static boolean condition4(){
        throw new RuntimeException();
    }

}
