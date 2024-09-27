import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Ex03_파일저장 {
    public static void main(String[] args) {
        String filePath = "./test.txt";
        String content = "안녕하세요 자바";

        byte[] buffer = null;

        try {
            buffer = content.getBytes("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        OutputStream os = null;
        try {
            os = new FileOutputStream(filePath);
            os.write(buffer);
        } catch (FileNotFoundException e) {
            System.err.println("[ERROR] " + e.getMessage());
            System.err.println("------------");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("[ERROR] " + e.getMessage());
            System.err.println("-------------");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
            System.err.println("-------------");
            e.printStackTrace();
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}