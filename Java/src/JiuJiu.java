/**
 * Created by Jax on 2016/10/31.
 */
public class JiuJiu {
    public static void main(String[] args) {
        int rows = 9;

        for (int colmuns = 1; colmuns < 10; colmuns++) {
            for (int i = 1; i < colmuns+1; i++){
                System.out.print(colmuns + "X" + i + "=" + colmuns * i + " ");
            }
            System.out.println();
        }
    }
}
