import java.io.File;
import java.util.Scanner;

/**
 * Created by Jax on 2016/11/1.
 */
public class FileClass {
    public static void main(String[] args) {
        String filePath = "D:\\Learn\\readB";
        String fileName = "D:\\Learn\\readB\\GT9.csv";

        File file = new File(filePath);
        String[] fileList = file.list();
        for (String str: fileList) {
            System.out.println(str);
        }
        File[] filePathList = file.listFiles();
        for (File fstr:
             filePathList) {
            System.out.println(fstr);
        }
        File file1 = new File(fileName);
        System.out.println("File? : " + file.isFile());
        System.out.println("Dir? : " + file1.isDirectory());
        Scanner sc = new Scanner(System.in);
        String ipStr = sc.next();
//        (new FileClass()).dropFile(new File(ipStr));
        (new FileClass()).allFiles(new File(ipStr));
    }

    public void foreach(File filePath) {

    }
    public void dropFile(File filePath) {
        if(filePath.exists()) {
            filePath.delete();
            System.out.println("Success!");
        } else {
            System.out.println("File is not exist.");
        }
    }

    public void allFiles(File filePath) {
        if(filePath.exists()) {
            if (filePath.isDirectory()) {
                File[] files = filePath.listFiles();
                if (files != null) {
                    for (File ftem:
                         files) {
                        allFiles(ftem);
                    }
                } else {
                    System.out.println(files);
                }
            } else {
                System.out.println(filePath);
            }
        } else {
            System.out.println("无效路径");
        }
    }
}
