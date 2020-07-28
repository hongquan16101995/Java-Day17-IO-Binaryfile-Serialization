package Optional_BT_copyfile;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("text1")));
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File("text2")));
            int read;
            int count = 0;
            while ((read = inputStream.read()) != -1) {
                outputStream.write(read);
                count++;
            }
            outputStream.close();
            System.out.println(count);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
}
