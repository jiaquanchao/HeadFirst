import java.io.*;

/**
 * Created by Jax on 2016/11/3.
 */
public class BReader {

    public static void randw() throws IOException {
        File file = new File("D:/Learn/" + "randw22.txt");
        File file1 = new File("D:/Learn/" + "randw22222.txt");

        Reader reader = new FileReader(file);
        Writer writer = new FileWriter(file1);
        char[] temp = new char[32];
        int len = 0;

        while ((len = reader.read(temp)) != -1) {
            writer.write(temp, 0, len);
            writer.flush();
            System.out.println(new String(temp));
            System.out.println(len);
        }
        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        randw();
//        File file = new File("D:/Learn/" + "randw22.txt");
//        File file1 = new File("D:/Learn/" + "randw222.txt");
//
//        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//        Writer writer = new BufferedWriter(new FileWriter(file1));
//        char[] temp = new char[32];
//        int len = 0;
//
//        while ((len = reader.read(temp)) != -1) {
//            writer.write(temp, 0, len);
//            writer.flush();
//            System.out.println(new String(temp));
//            System.out.println(len);
//        }
//        reader.close();
//        writer.close();
    }
}
