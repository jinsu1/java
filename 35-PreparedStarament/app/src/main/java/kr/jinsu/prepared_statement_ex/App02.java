package kr.jinsu.prepared_statement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import kr.jinsu.helpers.DBHelper;

public class App02 {
    public static void main(String[] args) {
        // 삭제할 학생의 학번 입력받기
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("학번: ");
        int studno = scanner.nextInt();

        scanner.close();

        /** SQL구문 정의하기 */
        String sql = "delete from student where studno=?";

        Connection conn = DBHelper.getInstance().open();

        // SLQ문의 템플릿을 사용하여 쿼리 실행을 준비하는 객체
        PreparedStatement pstmt = null;

        // 결과값 (저장된 데이터의 수)
        int result = 0;

        try {
            // pstmt 객체 할당 --> auto_increment 조회 옵션 사용함
            pstmt = conn.prepareStatement(sql);

            // SQL문의 ? 자리에 데이터를 바인딩
            pstmt.setInt(1, studno);

            // SQL문 실행하기 ==> 결과 행 리턴됨 ( 주의 : 파라미터 없음)
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //SQL을 수행하는 과정에서 생성한 객체는 반드시 생성 역순으로 닫아야 함
            if(pstmt != null) {
                //객체 닫기
                try {
                    pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
        }

        System.out.println(result + " Record Delete");

        DBHelper.getInstance().close();
    }
}
