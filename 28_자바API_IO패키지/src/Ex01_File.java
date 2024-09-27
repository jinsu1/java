import java.io.File;

public class Ex01_File {
    public static void main(String[] args) {
        File f1 = new File("./test.txt");

        boolean is_file = f1.isFile();
        System.out.println("isFile=" + is_file);

        boolean is_dir = f1.isDirectory();
        System.out.println("isDirectory=" + is_dir);

        boolean is_hidden = f1.isHidden();
        System.out.println("isHidden=" + is_hidden);

        String abs = f1.getAbsolutePath();
        System.out.println("절대경로: " + abs);

        boolean is_exist = f1.exists();
        System.out.println("존재여부: " + is_exist);
    }       
}