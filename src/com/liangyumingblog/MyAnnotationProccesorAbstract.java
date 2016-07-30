
package com.liangyumingblog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class MyAnnotationProccesorAbstract
{
    protected Class<?> clazz;

    protected Field[] fields;

    protected Method[] methods;

    private void setFieldContent()
    {
        fields = clazz.getDeclaredFields();
    }

    private void setMethods()
    {
        methods = clazz.getDeclaredMethods();
    }

    protected void setClazz(Class<?> clazz)
    {
        this.clazz = clazz;
        setFieldContent();
        setMethods();
    }

}
