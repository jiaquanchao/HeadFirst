package com.java.part6;

/**
 * Created by Jax on 2016/11/14.
 */
public class CacheName {
    private static int CACHE_MAX = 10;
    private static int flag = 0;
    private static CacheName[] cacheNames= new CacheName[CACHE_MAX];

    private final String name;
    private final int id;

    private CacheName(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static CacheName valueOf(String name, int id) {
        for(CacheName c : cacheNames) {
            if (c != null && name.equals(c.name) && id == c.id) {
                return c;
            }
        }
        if(flag == CACHE_MAX) {
            flag = 0;
        }
        cacheNames[flag] = new CacheName(name, id);
        flag ++;
        return cacheNames[flag-1];
    }

    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }
        if (object != null && object instanceof CacheName) {
            CacheName cn_new = (CacheName)object;
            System.out.println(this.name + "...equals..." + cn_new.getName());
            if (cn_new.id == this.id&&cn_new.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        System.out.println(this.name +" ...hashCode");
        return this.name.hashCode()+id*31;
    }
}
