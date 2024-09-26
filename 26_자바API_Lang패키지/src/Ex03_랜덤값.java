import kr.hossam.helper.UtilHelper;

public class Ex03_랜덤값 {
    public static void main(String[] args) {
        UtilHelper utilHelper = UtilHelper.getInstance();

        int randomNumber = utilHelper.random(0, 9);
        System.out.printf("randomNumber=%d\n", randomNumber);
            
        String authNum = "";

        for(int i=0; i<6; i++) {
            authNum += utilHelper.random(0, 9);
        }

        System.out.printf("인증번호 =%s\n", authNum);
    }
}


