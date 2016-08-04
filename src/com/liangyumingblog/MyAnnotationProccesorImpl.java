
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
    public Object process(Object object, boolean decry)
        throws Exception
    {
        Class clzz = object.getClass();
        Object o = object.getClass().newInstance();
        this.setClazz(clzz);
        for (Field field : fields)
        {
            if (field.isAnnotationPresent(SensitiveField.class))
            {
                if (!field.isAccessible())
                {
                    field.setAccessible(true);
                }
                SensitiveField getWay = field.getAnnotation(SensitiveField.class);
                String Way;
                if (decry)
                    Way = getWay.decryWay();
                else
                    Way = getWay.encryWay();
                field.set(o, Way);
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

    @Around("execution(* com.liangyumingblog.SimilarDataBase.insert(..))")
    public void encry(ProceedingJoinPoint joinPoint)
        throws Throwable
    {

        joinPoint.proceed(new Object[] {this.process(joinPoint.getArgs()[0], false)});
    }

    @Around("execution(* com.liangyumingblog.SimilarDataBase.query(..))")
    public void decry(ProceedingJoinPoint joinPoint)
        throws Throwable
    {

        joinPoint.proceed(new Object[] {this.process(joinPoint.getArgs()[0], true)});
    }
}
