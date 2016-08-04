
package com.liangyumingblog;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public interface Proccesor
{

    Object process(Object o, boolean decry)
        throws Exception;
}
