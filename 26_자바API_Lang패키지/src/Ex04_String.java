public class Ex04_String {
    public static void main(String[] args) {
        String msg = "Life is too short. You need Java!";
        System.out.println("문자열: " + msg);

        int len = msg.length();
        System.out.println("문자열의 길이: " + len);

        char str2nd = msg.charAt(2);
        System.out.println("두 번째 글자: " + str2nd);

        int p1 = msg.indexOf("f");
        System.out.println("'f'가 처음 나타나는 위치: " + p1);

        // 없음 : -1
        System.out.println("'z'가 처음 나타나는 위치: " + msg.indexOf("z"));

        System.out.println("'short'가 처음 나타나는 위치: " + msg.indexOf("short"));

        //indexOf에 파라미터가 두 개일 경우 두번째 숫자 값은 첫번째 파라미터의 글자를 찾기 시작하는 위치
        int p2 = msg.indexOf("i");
        int p3 = msg.indexOf("i", p2 + 1);
        System.out.println("'i'가 첫 번째로 나타나는 위치 : " + p2);
        System.out.println("'i'가 두 번째로 나타나는 위치 : " + p3);

        //뒤에서 부터 찾는게 아니라 마지막 위치임
        int p4 = msg.lastIndexOf("a");
        System.out.println("'a'의 마지막 위치: " + p4);

        if (msg.indexOf("Hello") > -1 ) {
            System.out.println("Hello가 포함됨");
        } else {
            System.out.println("Hello가 포함되지 않음");
        }

        //0번째부터 지정된 위치의 전까지 잘라내서 출력
        String substring1 = msg.substring(0, 18);
        System.out.println("문자열 자르기 :" + substring1);

        //파라미터가 하나일 경우 지정된 위치부터 끝까지 잘라내서 출력
        String substring2 = msg.substring(19);
        System.out.println("문자열 자르기: " + substring2);

        String up = msg.toUpperCase();
        System.out.println("모든 글자의 대문자 변환 : " + up);

        String low = msg.toLowerCase();
        System.out.println("모든 글자의 소문자 변환: " + low);

        //문자열의 앞, 뒤 만의 공백 지우기
        String src1 = " Hello World ";
        String src2 = src1.trim();
        System.out.printf("src1=[%s]\n", src1);
        System.out.printf("src2=[%s]\n", src2);

        String txt = "HTML,CSS,Javascript";
        String[] arr = txt.split(",");

        for(int i=0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        String txt2 = txt.replace(",", "$");
        System.out.println(txt2);

        String txt3 = "Hello";
        System.out.println(txt3.equals("hello"));

        if(txt3.equals("Hello")) {
            System.out.println("txt3는 Hello 입니다.");
        } else {
            System.out.println("txt3는 Hello가 아닙니다.");        
        }
    }
}
