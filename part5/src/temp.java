import java.io.*;

/**
 * Created by Jax on 2016/11/16.
 */
public class temp {



    public static void main(String[] args) throws IOException {

        int hour = 6;
        int MINUTE_MAX = 60;
        int MINUTE_MIN = 0;
        int minute = 26;
        String h = null;
        String m = null;
        boolean flag = true;
        File f = new File("D:\\Learn\\HeadFirst\\part5\\2.csv");
        FileWriter opsw = new FileWriter(f, true);
        opsw.write("time\n");
        while (true) {

            minute += 4;
            if (minute >= 60) {
                minute -= 60;
                hour += 1;

            }
            if (hour == 9 && minute>30) {
                break;
            }
            if(minute<10) {
                m = "0" + minute;
            } else {
                m = String.valueOf(minute);
            }

            String tem = String.valueOf(hour)+":"+m+"\n";
            opsw.write(tem);
        }
        opsw.close();
    }
}
