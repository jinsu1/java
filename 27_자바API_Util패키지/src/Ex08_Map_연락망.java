import java.util.HashMap;
import java.util.Map;

class Member {
        private String phoneNo;
        private String email;

        public Member(String phoneNo, String email) {
            this.phoneNo = phoneNo;
            this.email = email;
        }

        @Override
        public String toString() {
            return "{" +
                " phoneNo='" + phoneNo + "'" +
                ", email='" + email + "'" +
                "}";
        }
    }

    public class Ex08_Map_연락망 {
        public static void main(String[] args) {
            Map<String, Member> map = new HashMap<String, Member>();

            Member mem1 = new Member("010-1234-5678", "member@naver.com");
            map.put("철수", mem1);

            map.put("수현", new Member("010-1234-5678", "member2@kakao.com"));
            map.put("석훈", new Member("010-1223-5611", "member2@gmail.com"));
            map.put("민영", new Member("010-1111-2222", "member2@hanmil.net"));
            map.put("호영", new Member("010-1444-5444", "member2@icloud.com"));

            Member output = map.get("호영");
            System.out.println(output.toString());
        }
}
