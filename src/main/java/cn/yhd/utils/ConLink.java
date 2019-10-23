package cn.yhd.utils;

import cn.yhd.bean.User;
import cn.yhd.service.TestService;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author yuhuadong
 * @date 2019/9/19
 */
public class ConLink {
    Predicate predicate;
    ConLink nextFunction;
    ConLink currentFunction;

    public static void main(String[] args){
        TestService testService = new TestService();
        ConLink conditionLink = new ConLink(testService::isNotNull);
        conditionLink.setNextFunction( new ConLink(testService::isUsernameNotNull));
        conditionLink.setNextFunction( new ConLink(testService::isPasswordNotNull));
        conditionLink.setNextFunction( new ConLink(testService::isUsername));
        conditionLink.setNextFunction( new ConLink(testService::isPassword));
        User user = new User();
        user.setUsername("A");
        user.setPassword("B");
        System.out.println(conditionLink.isMatch(user));
    }
    ConLink(Predicate<User> predicate){
        this.predicate = predicate;
        this.currentFunction = this;
    }

    public boolean isMatch(Object t){
        if(nextFunction==null){
            return predicate.test(t);
        }
        return predicate.test(t)&&nextFunction.isMatch(t);
    }

    public void setNextFunction(ConLink nextFunction) {
        this.currentFunction.nextFunction = nextFunction;
        this.currentFunction = nextFunction;
    }
}
