import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Jax on 2016/11/1.
 */
public class ReadBlob {

    public static void main(String[] args) throws IOException {


//        for (int i = 3; i<=13; i++) {
        int i = 13;
            File f = new File("D:\\WCData\\1020\\NewData\\"+i+"t");

            InputStream fi = null;
            fi = new FileInputStream(f);
            byte[] buffer = new byte[(int) f.length()];
            int offset = 0;
            int numRead = 0;
            while (offset < buffer.length
                    && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }
            // 确保所有数据均被读取
            if (offset != buffer.length) {
                throw new IOException("Could not completely read file "
                        + f.getName());
            }
            fi.close();


            System.out.println(buffer.length);
            ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
//        File file = new File("graph"+i+".csv");
//        FileOutputStream fos = new FileOutputStream(file);
//        DataOutputStream out = new DataOutputStream(fos);
            PrintStream ps = new PrintStream("GT"+i+".csv");
            float iii;
            while (byteBuffer.hasRemaining()) {
                iii = byteBuffer.getFloat();
                System.out.println(byteBuffer.getFloat());

                ps.println(iii);
            }

//            i++;
            System.out.println();
            System.out.println(byteBuffer.position());
//        }
    }
}
