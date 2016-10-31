import java.util.Arrays;

/**
 * Created by Jax on 2016/10/31.
 */
public class Arri {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int[] b = Arrays.copyOf(a, 4);
        b[3] = 9;
        System.out.println("a == b : "+ (a==b));
        System.out.println(" a equals b : " + (a.equals(b)));
        System.out.println("a array equals b : "+ Arrays.equals(a, b));
        System.out.println(a);
        System.out.println("+++++============+++++");

        String str1 = "abc";
        String str2 = "abc";
        String str3 = str1 + str2;
        String str4 = str1 + "abc";
        System.out.println(str3 == "abcabc");
    }
}
