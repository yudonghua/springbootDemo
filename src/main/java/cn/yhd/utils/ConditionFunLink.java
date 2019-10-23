package cn.yhd.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author yuhuadong
 * @date 2019/9/19
 */
public class ConditionFunLink<T> {
    Function<T,Boolean> function;
    ConditionFunLink<T>  nextFunction;

    public static void main(String[] args){
        ConditionFunLink conditionFunLink = new ConditionFunLink<String>(isNull());
//        Function function = ConditionFunLink::toString;
        Function function2 = Object::toString;
        System.out.println(function2.apply("dd"));
        conditionFunLink.nextFunction=new ConditionFunLink<String>(isA());
        System.out.println(conditionFunLink.isMatch("a"));
    }
    ConditionFunLink(Function<T,Boolean> function){
        this.function =function;
    }
    public boolean and(T t){
        if(nextFunction==null){
            return function.apply(t);
        }
        return function.apply(t)&&nextFunction.isMatch(t);
    }

    public boolean isMatch(T t){
        if(nextFunction==null){
            return function.apply(t);
        }
        return function.apply(t)&&nextFunction.isMatch(t);
    }
    public static Function<String,Boolean> isNull(){
        return i->i!=null;
    }
    public static Function<String,Boolean> isA(){
        return i->i.equals("a");
    }

}
