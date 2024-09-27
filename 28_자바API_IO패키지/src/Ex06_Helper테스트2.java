import kr.hossam.helpers.FileHelper;

public class Ex06_Helper테스트2 {
    public static void main(String[] args) {
        String filePath = "./helper테스트2.txt";
        String content = "이것은 테스트2 입니다.";

        //저장 테스트
        try {
            FileHelper.getInstance().writeString(filePath, content);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //읽기 테스트
        try {
            byte[] read = FileHelper.getInstance().read(filePath);
            System.out.println(read);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}


