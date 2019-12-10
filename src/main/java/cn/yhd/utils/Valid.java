package cn.yhd.utils;

import java.lang.annotation.*;

/**
 * @author master
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Inherited
public @interface Valid {
}