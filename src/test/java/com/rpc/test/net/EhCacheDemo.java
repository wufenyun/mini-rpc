package com.rpc.test.net;

import org.junit.Test;

import net.sf.ehcache.pool.sizeof.ReflectionSizeOf;
import net.sf.ehcache.pool.sizeof.SizeOf;

public class EhCacheDemo {
    
    @Test
    public void size() {
        SizeOf so = new ReflectionSizeOf();
        System.out.println(so.sizeOf(new Bean()));
    }
}

class Bean {
    public int i = 0;
    public int j = 0;
    public String str = "aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa"
            +"aaaaaaaaaaaaaaaaaa"+"aaaaaaaaaaaaaaaaaa";
    public long l = 11111111111111l; 
    public long l2 = 11111111111111l; 
    public long l3 = 11111111111111l; 
}