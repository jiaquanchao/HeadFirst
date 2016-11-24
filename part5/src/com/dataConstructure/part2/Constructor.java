package com.dataConstructure.part2;

/**
 * Created by Jax on 2016/11/23.
 */
class Fu {
//    public Fu(){
//        System.out.println("Fu 的无参构造");
//    }
    public Fu(int f){
        System.out.println("Fu 的有参构造：" + f);
    }
    public Fu(int f1, int f2) {
        System.out.println("Fu de liange canchu");
    }
}
public class Constructor extends Fu{
    public Constructor() {
        super(3);
        System.out.println("父类为 4，子类为无参");
    }


}
