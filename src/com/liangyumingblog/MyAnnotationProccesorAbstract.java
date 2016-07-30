
package com.liangyumingblog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public abstract class MyAnnotationProccesorAbstract
{
    protected Object object;

    protected Field[] fields;

    protected Method[] methods;

    private void setFieldContent()
    {
        fields = object.getClass().getDeclaredFields();
    }

    private void setMethods()
    {
        methods = object.getClass().getDeclaredMethods();
    }

    protected void setClazz(Object object)
    {
        this.object = object;
        setFieldContent();
        setMethods();
    }

}
