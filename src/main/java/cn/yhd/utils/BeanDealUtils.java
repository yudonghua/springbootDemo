package cn.yhd.utils;

import cn.yhd.base.NotEmpty;
import cn.yhd.base.NotNull;
import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author: yuhuadong
 * @Date: 2019/8/28 6:08 PM
 * @Description:
 */
public class BeanDealUtils {
    public static <T> List<T> copyList(List list,Class<T> clazz) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList();
        }
        return JSON.parseArray(JSON.toJSONString(list),clazz);
    }
    /**
     * 当对象中存在list,BeanUtils无法转换
     **/
    public static <F,T> T copy(F f,Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(f), clazz);
    }

    public static void makeModel(Object object) {
        List<Field> fieldList = new ArrayList<>();
        Class clazz = object.getClass();
        while ( clazz != Object.class) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        for (Field field : fieldList) {
            field.setAccessible(true);
            try {
                if(String.class.isAssignableFrom(field.getType())){
                    field.set(object,field.getName());
                }else if(Number.class.isAssignableFrom(field.getType())){
                    field.set(object, field.getType().getConstructor(String.class).newInstance("0"));
                }else if(Boolean.class.isAssignableFrom(field.getType())){
                    field.set(object, field.getType().getConstructor(String.class).newInstance("false"));
                }else if(List.class.isAssignableFrom(field.getType())){
                }else {
                    field.set(object, field.getType().getConstructor().newInstance());
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException("makeModel error");
            }finally {
                field.setAccessible(false);
            }

        }
    }

    public static <F,T> void getDiff(F fromA,F fromB,T targetA,T targetB) {
        List<Field> fieldList = new ArrayList<>();
        Class clazz = fromA.getClass();
        while ( clazz != Object.class) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        for(Field field:fieldList){
            try {
                field.setAccessible(true);
                if(field.get(fromA)==null||field.get(fromB)==null){
                    continue;
                }
                if(!field.get(fromA).equals(field.get(fromB))){
                    Field target = targetA.getClass().getDeclaredField(field.getName());
                    try {
                        target.setAccessible(true);
                        target.set(targetA, field.get(fromA));
                        target.set(targetB, field.get(fromB));
                    } catch (Exception e) {
                    }finally {
                        target.setAccessible(false);
                    }
                }
            } catch (Exception e) {
            }finally {
                field.setAccessible(false);
            }
        }
    }

    public static void valid(Object object) {
        List<Field> fieldList = new ArrayList<>();
        Class clazz = object.getClass();
        while ( clazz != Object.class) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        for (Field field : fieldList) {
            boolean notNull = field.isAnnotationPresent(NotNull.class);
            boolean notEmpty = field.isAnnotationPresent(NotEmpty.class);
            if (notNull) {
                field.setAccessible(true);
                Object o;
                try {
                    o = field.get(object);
                } catch (Exception e) {
                    throw new IllegalArgumentException("valid error");
                }finally {
                    field.setAccessible(false);
                }
                if(o == null){
                    NotNull nullName = field.getAnnotation(NotNull.class);
                    String describe = nullName==null||"".equals(nullName.name())?field.getName():nullName.name();
                    throw new IllegalArgumentException(describe + " can not be null");
                }
            }
            if (notEmpty) {
                field.setAccessible(true);
                Object o;
                try {
                    o = field.get(object);
                } catch (Exception e) {
                    throw new IllegalArgumentException("valid error");
                }finally {
                    field.setAccessible(false);
                }
                NotEmpty emptyName = field.getAnnotation(NotEmpty.class);
                String describe = emptyName==null||"".equals(emptyName.name())?field.getName():emptyName.name();
                if(o == null){
                    throw new IllegalArgumentException(describe + " can not be null");
                }
                if(Collection.class.isAssignableFrom(o.getClass())){
                    if(CollectionUtils.isEmpty((Collection)o)){
                        throw new IllegalArgumentException(describe + " can not be empty");
                    }
                }else if(CharSequence.class.isAssignableFrom(o.getClass())){
                    if(StringUtils.isEmpty((CharSequence)o)){
                        throw new IllegalArgumentException(describe + " can not be empty");
                    }
                }
            }

        }
    }
}
