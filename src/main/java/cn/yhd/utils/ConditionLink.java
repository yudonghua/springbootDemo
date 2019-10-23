package cn.yhd.utils;

import cn.yhd.bean.User;
import cn.yhd.service.TestService;

import java.util.function.Function;

/**
 * @author yuhuadong
 * @date 2019/9/19
 */
public class ConditionLink<T> {
    private Function<T,Boolean> function;
    private ConditionLink<T> nextFunction;
    private ConditionLink<T> currentFunction;

    public static void main(String[] args){
        TestService testService = new TestService();
        ConditionLink<User> conditionLink = new ConditionLink<>(testService::isNotNull);
        conditionLink.setNextCondition( new ConditionLink<>(testService::isUsernameNotNull));
        conditionLink.setNextCondition( new ConditionLink<>(testService::isPasswordNotNull));
        conditionLink.setNextCondition( new ConditionLink<>(testService::isUsername));
        conditionLink.setNextCondition( new ConditionLink<>(testService::isPassword));
        User user = new User();
//        user.setUsername("D");
        user.setPassword("B");
        System.out.println(conditionLink.isMatch(user));
    }
    ConditionLink(Function<T,Boolean> function){
        this.function = function;
        this.currentFunction = this;
    }

    public boolean isMatch(T t){
        if(nextFunction==null){
            return function.apply(t);
        }
        return function.apply(t)&&nextFunction.isMatch(t);
    }

    public void setNextCondition(ConditionLink<T> nextFunction) {
        this.currentFunction.nextFunction = nextFunction;
        this.currentFunction = nextFunction;
    }
}
