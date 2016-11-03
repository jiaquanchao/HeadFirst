import java.io.*;
import java.nio.FloatBuffer;

/**
 * Created by Jax on 2016/11/2.
 */
public class ReadA {
    private void creatA(String f, String fo) throws IOException {
        File file = new File(f);
        File fileo = new File(fo);
        byte[] bytes = new byte[4];
        InputStream ips = new FileInputStream(file);
//        OutputStream ops = new FileOutputStream(fileo);
        Writer writer = new OutputStreamWriter(new FileOutputStream(fileo));
        int len = 0;
        FloatBuffer floatBuffer = null;
        String temp = null;
        while ((len = ips.read(bytes)) != -1) {
            float ftemp = byte2float(bytes, 0);
            writer.write(String.valueOf(ftemp));
            writer.write("\n");
            System.out.println(String.valueOf(ftemp));
        }
        ips.close();
        writer.close();

    }

    public static float byte2float(byte[] b, int index) {
        int l;
        l = b[index + 0];
        l &= 0xff;
        l |= ((long) b[index + 1] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 2] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 3] << 24);
        return Float.intBitsToFloat(l);
    }

    public static void main(String[] args) throws IOException {
        int sampleNum = 13;
        String[] type = new String[]{"a", "t"};
        for (String strtemp:
                type) {
            for (int i = 1; i <= sampleNum; i++) {
                String filePath = "D:\\WCData\\1020\\NewData\\" + i + strtemp;
                String outPath = "D:\\WCData\\1020\\NewData\\Graph" + i + strtemp +".csv";
                ReadA rA = new ReadA();
                rA.creatA(filePath, outPath);
            }
        }
    }
}
