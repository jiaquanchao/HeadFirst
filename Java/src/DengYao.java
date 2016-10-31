/**
 * Created by Jax on 2016/10/31.
 */
public class DengYao {

    public void PrintX(int l) {
        int pNum = l + 1;

        for (int j = 0; j < pNum; j++) {
            char[] block = new char[pNum-j-1];
            char[] xing = new char[2*l+1];
            for(int i = 1; i < pNum-j; i++) {
                block[i] = ' ';
            }
            for (int i = -1; i < j; i++) {
                xing[i+1] = '*';
            }
            for(char i : block) {
                System.out.print(i);
            }
            for(char i : xing) {
                System.out.print(i);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        DengYao dy = new DengYao();
        dy.PrintX(2);
    }
}
