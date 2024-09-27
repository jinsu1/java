import kr.hossam.exceptions.StringFormatException;
import kr.hossam.helpers.RegexHelper;

public class Ex13_RegexHelperTest {
    public static void main(String[] args) {
        RegexHelper regexHelper = RegexHelper.getInstance();

        String name = "박진수";
        String age = "29";
        String email = "jinsu4205@kakao.com";
        String phone = "01012345678";

        try {
            regexHelper.isValue(name, "이름을 입력하세요.");
            regexHelper.isKor(name, "이름은 한글만 입력하세요.");

            regexHelper.isValue(age, "나이를 입력하세요.");
            regexHelper.isNum(age, "나이는 숫자만 입력 가능합니다.");
            
            regexHelper.isValue(email, "이메일을 입력하세요.");
            regexHelper.isEmail(email, "이메일 형식이 잘못되었습니다.");

            regexHelper.isValue(phone, "연락처를 입력하세요.");
            regexHelper.isPhone(phone, "연락처 형식이 잘못되었습니다.");
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
            System.out.println("-------------");
            e.printStackTrace();
        }
    }
}
