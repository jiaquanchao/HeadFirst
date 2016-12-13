package com.jdbc;

import java.io.*;
import java.nio.FloatBuffer;
import java.sql.Blob;

/**
 * Created by Jax on 2016/11/5.
 */
public class ReadB {

    private void creatB(String f, String fo) throws IOException {
        File file = new File(f);
        File fileo = new File(fo);
        byte[] bytes = new byte[4];
        InputStream ips = new FileInputStream(file);
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

    public void readB(Blob blob, File file) throws Exception {
        InputStream inputStream = blob.getBinaryStream();
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        byte[] bytes = new byte[4];
        while (inputStream.read(bytes) != -1) {
            float ftemp = ReadB.byte2float(bytes, 0);
            writer.write(String.valueOf(ftemp));
            writer.write("\n");
        }
        inputStream.close();
        writer.close();
    }

    public void readB(Long resultId, Blob blobT, Blob blobA, File file) throws Exception {
        InputStream inputStreamT = blobT.getBinaryStream();
        InputStream inputStreamA = blobA.getBinaryStream();
        Writer writer = new OutputStreamWriter(new FileOutputStream(file, true));
        byte[] bytesT = new byte[4];
        byte[] bytesA = new byte[4];
        while ((inputStreamT.read(bytesT) != -1) && (inputStreamA.read(bytesA) != -1)) {
            float ftemp = ReadB.byte2float(bytesT, 0);
            float atemp = ReadB.byte2float(bytesA, 0);
            writer.write(String.valueOf(resultId)+","+String.valueOf(ftemp) + "," + String.valueOf(atemp) + "\n");
        }
        inputStreamT.close();
        inputStreamA.close();
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
}
