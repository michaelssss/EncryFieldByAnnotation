
package com.liangyumingblog;

import org.springframework.stereotype.Component;

@Component
public class SimilarDataBase
{
    public void insert(Object str)
    {
        System.out.println("insert to DB: " + str);
    }
}
