
package com.liangyumingblog;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public interface Proccesor
{

    void process(Object o)
        throws IllegalArgumentException, IllegalAccessException;
}
