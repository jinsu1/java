package kr.jinsu.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.models.Department;

public class App03 {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App03.class);

        /** 2) 수정할 데이터 입력받기 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("수정할 학과 이름: ");
        String dname = scanner.nextLine();

        System.out.print("수정할 위치: ");
        String loc = scanner.nextLine();

        System.out.print("수정할 학과 번호: ");
        int deptno = scanner.nextInt();

        scanner.close();

        /** 3) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 4) update를 수행할 데이터 생성 */
        Department model = new Department();
        model.setDeptno(deptno);
        model.setDname(dname);
        model.setLoc(loc);

        /** 5) 데이터 수정 */
        int result = 0;
        try {
            result = sqlSession.update("DepartmentMapper.update", model);

            if (result == 0) {
                throw new Exception("수정된 데이터가 없습니다.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        /** 6) 결과 판별 */
        logger.debug(result + "개의 데이터 수정됨");

        /** 7) DB 접속 해제 */
        sqlSession.commit();
        sqlSession.close();
    }
}
