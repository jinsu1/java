/*
 * This source file was generated by the Gradle 'init' task
 */
package kr.jinsu.prepared_statement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.jinsu.helpers.DBHelper;

public class App01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("학과명: ");
        String dname = scanner.nextLine();

        System.out.print("위치: ");
        String loc = scanner.nextLine();

        scanner.close();

        /** SQL구문 정의하기 */
        // department 테이블에 컴퓨터정보과를 추가하기 위한 SQL의 템플릿
        // deptno 컬럼은 auto_increment 이므로 insert에서 명시하지 않아도 된다.
        String sql = "INSERT INTO department (dname, loc) VALUE (?, ?)";

        Connection conn = DBHelper.getInstance().open();

        // SLQ문의 템플릿을 사용하여 쿼리 실행을 준비하는 객체
        PreparedStatement pstmt = null;

        ResultSet rs = null;

        // 결과값 (저장된 데이터의 수)
        int result = 0;

        // 결과값 (생성된 auto_increment 값)
        int autoGeneratedID = 0;

        try {
            // pstmt 객체 할당 --> auto_increment 조회 옵션 사용함
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // SQL문의 ? 자리에 데이터를 바인딩
            pstmt.setString(1, dname);
            pstmt.setString(2, loc);

            // SQL문 실행하기 ==> 결과 행 리턴됨 ( 주의 : 파라미터 없음)
            result = pstmt.executeUpdate();

            //생성된 auto_increment값 얻기
            rs = pstmt.getGeneratedKeys();
            rs.next();
            autoGeneratedID = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //SQL을 수행하는 과정에서 생성한 객체는 반드시 생성 역순으로 닫아야 함
            if(rs != null) {
                //객체 닫기
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(result + " Record Insert");
        System.out.println("New Deptno=" + autoGeneratedID);

        DBHelper.getInstance().close();
    }
}
