import java.io.*;

/**
 * Created by Jax on 2016/11/1.
 */
public class ReadFloat {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Learn\\readB\\graph1.csv");
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);
        int i = 0;
        float[] fa = new float[1000];
        while (dis.readBoolean()) {
            fa[i] = dis.readFloat();
            System.out.println(fa[i]);
        }
//        System.out.println(dis.readFloat());
    }
}
