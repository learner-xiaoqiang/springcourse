package com.lx;

import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {

    @Test
    public void testAdd(){
        HelloMaven hello=new HelloMaven();
        int res=hello.add(10,20);
        Assert.assertEquals(30,res);
    }
}
