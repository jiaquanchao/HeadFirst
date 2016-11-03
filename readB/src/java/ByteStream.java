import java.io.*;
import java.util.Scanner;

/**
 * Created by Jax on 2016/11/1.
 */
public class ByteStream {

    public void createFile(File file) {
        try {
            file.createNewFile();
            System.out.println("Creating file success!");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(file + " is already exists!");
        }
    }

    public void createDir(File file) {
        try {
            file.mkdir();
            System.out.println("Creating dir success!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(file + " is already exists!");
        }
    }

    public void outStr(String str, String f) throws IOException, InterruptedException {
        File file = new File(f);
        boolean outFlag = false;
        if(file.exists()) {
            System.err.println("文件已存在！\n是否追加：Y/N");
            Scanner sc = new Scanner(System.in);
            String flag = sc.next();
            if (flag.equals("N")) {
                System.out.println("是否覆盖：Y/N");
                String flag1 = sc.next();
                if (flag1.equals("N")) {

                }
                return;
            } else {
                System.err.println("追加文件 ...");
                outFlag = true;
                Thread.sleep(10);
            }
        } else {
            file.createNewFile();
            System.out.println("文件创建成功 ...");
            outFlag = true;
        }
        while (outFlag) {
            OutputStream ops = new FileOutputStream(file, true);
            byte[] bytes = str.getBytes();
            ops.write(bytes);
            ops.close();
            System.out.println("写入完成！");
            return;
        }
    }

    public String inStr(String f) throws IOException {
        File file = new File(f);
        InputStream ips = new FileInputStream(file);
        byte[] bytes = new byte[256];
//        ips.read(bytes);
//        int temp = ips.read();
//        ips.close();
//        System.out.println(new String(bytes));
//        System.out.println(temp);
//        System.out.println(bytes[0]);
        int len = 0;
        String text= new String();
        while ((len = ips.read(bytes)) != (-1)) {
            String temStr = new String(bytes, 0, len);
            text += temStr;
            System.out.println(new String(bytes));
        }
        ips.close();
        System.out.println(text);
        return text;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        String inPath = "D:/Learn/" + "randw.txt";
//        String outPath = "D:/Learn/" + "randw1.txt";
//        ByteStream bs = new ByteStream();
////        bs.outStr("hello world!", new File(filePath));
////        String str = "你好啊";
////        bs.inStr(new File(filePath));
//        String txt = bs.inStr(inPath);
//        bs.outStr(txt, outPath);

//        //copy
//        String oriPath = "D:/Learn/" + "randw2.txt";
//        String copyPath = "D:/Learn/" + "randw22.txt";
//
//        InputStream ips = new FileInputStream(new File(oriPath));
//        OutputStream ops = new FileOutputStream(new File(copyPath));
//
//        if ((ips != null) && (ops != null)) {
//            byte[] bytes = new byte[1024];
//            int len = 0;
//            int i = 0;
//            while ((len = ips.read(bytes)) != -1) {
////                ops.write(len);
//                ops.write(bytes, 0, len);
//                System.out.println("读写一次"+ ++i);
//            }
//        }
//
//        ops.close();
//        ips.close();
        System.out.println((byte)44);
    }
}
