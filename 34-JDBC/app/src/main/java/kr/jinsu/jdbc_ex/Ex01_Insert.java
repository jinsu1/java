/*
 * This source file was generated by the Gradle 'init' task
 */
package kr.jinsu.jdbc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex01_Insert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("학과 이름을 입력하세요: ");
        String dname = scanner.nextLine();

        System.out.print("학과의 위치를 입력하세요: ");
        String loc = scanner.nextLine();

        scanner.close();

        /** 1)데이터베이스에 접속하기 위한 정보를 변수로 구성 */
        String db_hostname = "127.0.0.1"; //이 프로그램이 구동되는 PC자체의 주소 = local
        int db_portnumber = 3306;
        String db_database = "myschool";
        String db_charset = "utf8";
        String db_username = "root";
        String db_password = "123qwe!@#";

        /** 2) 데이터베이스 접속 ==> mysql -uroot -p */
        // 접속 객체 선언
        Connection conn = null;

        // 접속 주소 구성
        String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimeZone=UTC";
        String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);
        // System.out.println(url);

        //MySQL JDBC의 드라이버 클래스를 로딩해서 DriverManager클래스에 등록한다.

       try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //DriverManager 객체를 사용하여 DB에 접속한다.
            // --> 접속 URL, 아이디, 비밀번호를 전달
            // --> DriverManager에 등록된 Driver 객체를 사용하여 DB에 접속 후,
            // Connection 객체를 리턴받는다.
            // --> import java.sql.DriverManager 필요함
            conn = DriverManager.getConnection(url, db_username, db_password);
        } catch (ClassNotFoundException e) {
            System.out.println("===== MySQL Driver Loading Fail =====");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("===== MySQL Connection Fail ======");
            e.printStackTrace();
        }  

        /** 수행할 SQL문을 문자열 변수로 준비  */
        String sql = "INSERT INTO department (dname, loc) VALUES ('" + dname + "', '" + loc + "')";

        /** MySQL에게 SQL 문을 전달하고 결과를 반환받기 */
        // SQL문을 실행할 수 있는 객체
        Statement stmt = null;
        // 결과값 (저장된 데이터의 수)
        int result = 0;

        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("===== Query Error =====");
            e.printStackTrace();
        } finally {
            // SQL 구문의 에러 여부에 상관없이 stmt 객체를 닫기 위하여 finally 블록 사용.
            // --> 객체의 유효범위 설ㅈ정을 위해서 stmt 객체는 try 블록 밖에 선언되었다.

            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }  
            }
        }

        //결과 출력
        System.out.println(result + "개의 데이터가 저장됨");

        /** 데이터베이스의 접속을 해제한다. */
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("===== MySQL Disconnection Fail =====");
                System.out.println(e.getMessage());
            }
        }
    }
}
