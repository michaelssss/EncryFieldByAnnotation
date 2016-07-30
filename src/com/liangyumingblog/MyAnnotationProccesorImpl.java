
package com.liangyumingblog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Aspect
public class MyAnnotationProccesorImpl extends MyAnnotationProccesorAbstract implements Proccesor
{

    @Override
    public void process(Object object)
        throws IllegalArgumentException, IllegalAccessException
    {
        this.setClazz(object);
        for (Field field : fields)
        {
            if (field.isAnnotationPresent(EncryField.class))
            {
                if (!field.isAccessible())
                {
                    field.setAccessible(true);
                }
                EncryField getEncryWay = field.getAnnotation(EncryField.class);
                String EncryWay = getEncryWay.way();
                field.set(object, EncryWay);
            }
        }
    }

    @Around("execution(* com.liangyumingblog.Printor.print(..))")
    public void join(ProceedingJoinPoint joinPoint)
        throws Throwable
    {
        this.process(joinPoint.getArgs()[0]);
        joinPoint.proceed();
    }
}
