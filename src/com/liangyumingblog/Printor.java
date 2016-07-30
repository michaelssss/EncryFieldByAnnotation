
package com.liangyumingblog;

import org.springframework.stereotype.Component;

@Component
public class Printor
{
    public void print(Object str)
    {
        System.out.println(str);
    }
}
