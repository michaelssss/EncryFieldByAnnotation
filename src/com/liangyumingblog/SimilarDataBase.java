
package com.liangyumingblog;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SimilarDataBase
{
    private static Map<String, Object> DB = new ConcurrentHashMap<>();

    public void insert(Object str)
    {
        DB.putIfAbsent(str.getClass().getSimpleName(), str);
        System.out.println("insert to DB: " + str);
    }

    public void query(Object str)
    {
        Object s = DB.get(str.getClass().getSimpleName());
        System.out.println("query from DB" + s);
    }
}
