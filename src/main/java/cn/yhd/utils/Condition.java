package cn.yhd.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuhuadong
 * @date 2019/9/19
 */
public class Condition {
    private boolean aBoolean;
    List<Condition> conditions = new ArrayList<>();

    public static void main(String[] args){
        Condition condition = new Condition(isA());
        Condition conditionOR1 = new Condition(isB());
        Condition conditionOR2 = new Condition(isC());
        Condition conditionAND1 = new Condition(isD());
        Condition conditionAND2 = new Condition(isE());
        conditionAND1.addCondition(isD()||isE());
        condition.addCondition(isC());
        condition.addCondition(isB());
        condition.addCondition(isC()||isF());
        condition.addCondition(conditionAND1);
        condition.addCondition(conditionAND2);
        condition.addCondition(isMatch(conditionOR1)||isMatch(conditionOR2));
        System.out.println(isMatch(condition));
    }
    public static void testNull(){
    }

    public Condition(boolean aBoolean){
        this.aBoolean = aBoolean;
    }
    public Condition addCondition(boolean aBoolean){
        conditions.add(new Condition(aBoolean));
        return this;
    }
    public Condition addCondition(Condition condition){
        conditions.add(condition);
        return this;
    }
    public static boolean isMatch(Condition aCondition){
        if(!aCondition.aBoolean){
            return false;
        }
        for(Condition condition:aCondition.conditions){
            if(!isMatch(condition)){
                return false;
            }
        }
        return true;
    }
    public static boolean isA(){
        String a = null;
        return a!=null;
    }
    public static boolean isB(){
        return true;
    }
    public static boolean isC(){
        return true;
    }
    public static boolean isD(){
        return true;
    }
    public static boolean isE(){
        return true;
    }
    public static boolean isF(){
        return true;
    }

}
