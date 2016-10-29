package com.example.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jax on 2016/10/29.
 */
public class BeerExpert {

    public List getBrands(String color) {
        List brands = new ArrayList();
        if (color.equals("amber")) {
            brands.add("amber beer");
            brands.add("amber beer 2");
        } else {
            brands.add("Qing dao");
            brands.add("Lao shan");
        }
        return brands;
    }
}
