package com.java.part7;

import org.junit.Test;

import java.util.Locale;

/**
 * Created by Jax on 2016/11/17.
 */
public class LocalDemo {

    @Test
    public void test() {
        Locale[] locals = Locale.getAvailableLocales();
        for (Locale l:
             locals) {
            System.out.println(l.getCountry()+":"+l.getDisplayCountry()+
                                "\n"+l.getDisplayLanguage()+":"+l.getLanguage());

        }
    }
}
