package cn.yhd.utils;

import cn.yhd.base.NotEmpty;
import cn.yhd.base.NotNull;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;

@Aspect
@Component
public class ValidAspect {

	private static final Logger logger = LoggerFactory.getLogger(ValidAspect.class);

	/**
	 * 校验参数
	 */
	@Before("pointcut()")
	public void doBefore(JoinPoint joinPoint) {
		Object[] params = joinPoint.getArgs();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Annotation[][] annotations = method.getParameterAnnotations();
		String[] paramNames = signature.getParameterNames();
		for (int i = 0; i < annotations.length; i++) {
			Object param = params[i];
			Annotation[] paramAnn = annotations[i];
			for (Annotation annotation : paramAnn) {
				System.out.println(annotation.annotationType());
				if(Valid.class.equals(annotation.annotationType())){
					BeanDealUtils.valid(param);
				}else{
					String describe = paramNames[i];
					if(NotNull.class.equals(annotation.annotationType())){
						if(param == null){
							throw new IllegalArgumentException(describe + " can not be null");
						}
					}
					if(NotEmpty.class.equals(annotation.annotationType())){
						if(param == null){
							throw new IllegalArgumentException(describe + " can not be null");
						}
						if(Collection.class.isAssignableFrom(param.getClass())){
							if(CollectionUtils.isEmpty((Collection)param)){
								throw new IllegalArgumentException(describe + " can not be empty");
							}
						}else if(CharSequence.class.isAssignableFrom(param.getClass())){
							if(StringUtils.isEmpty((CharSequence)param)){
								throw new IllegalArgumentException(describe + " can not be empty");
							}
						}
					}
				}
			}
		}

	}
	/**
	 * 横切点
	 */
	@Pointcut(value = "@annotation(Valid)")
	private void pointcut() {
	}

}

