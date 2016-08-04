
package com.liangyumingblog;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SensitiveField
{
    String encryWay();

    String decryWay();
}
