package com.pl.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

public class HashMap_1 {
    @Test
    public void hashMap() {
        int n = 6;
        System.out.println(tableSizeFor(n));
        HashMap map = new HashMap(15);
        map.put("1", 1);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
