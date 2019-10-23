package cn.yhd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author yuhuadong
 * @date 2019/9/19
 */
public class ConditionFun {
    List<Function> conditions = new ArrayList<>();

    public static void main(String[] args){
        ConditionFun conditionFun = new ConditionFun();
        Function<String,Boolean> fun1= isNull();
        Function<String,Boolean> fun2= isA();
        conditionFun.conditions.add(fun1);
        conditionFun.conditions.add(fun2);
        System.out.println(isMatch(conditionFun,"a"));
        Function function2 = conditionFun::isTest;
    }
    public static <T> boolean isMatch(ConditionFun conditionFun,T t){
        for(Function<T,Boolean> function:conditionFun.conditions){
            if(!function.apply(t)){
                return false;
            }
        }
        return true;
    }
    public static Function<String,Boolean> isNull(){
        return i->i!=null;
    }
    public static Function<String,Boolean> isA(){
        return i->i.equals("a");
    }
    public String isTest(Object a){
        return "a.toString()";
    }

}
