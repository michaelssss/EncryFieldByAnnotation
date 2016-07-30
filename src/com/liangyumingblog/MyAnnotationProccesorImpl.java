
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
    public Object process(Object object)
        throws Exception
    {
        Class clzz = object.getClass();
        Object o = object.getClass().newInstance();
        this.setClazz(clzz);
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
                field.set(o, EncryWay);
            }
            else
            {
                field.setAccessible(true);
                Field field1 = clzz.getDeclaredField(field.getName());
                field1.setAccessible(true);
                field.set(o, field1.get(object));
            }
        }
        return o;
    }

    @Around("execution(* com.liangyumingblog.Printor.print(..))")
    public void join(ProceedingJoinPoint joinPoint)
        throws Throwable
    {

        joinPoint.proceed(new Object[] {this.process(joinPoint.getArgs()[0])});
    }
}
