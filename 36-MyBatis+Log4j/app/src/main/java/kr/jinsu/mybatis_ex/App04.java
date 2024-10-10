package kr.jinsu.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.models.Department;

public class App04 {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App04.class);

        /** 2) 조회할 데이터 입력받기 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("조회할 학과 번호: ");
        int deptno = scanner.nextInt();

        scanner.close();

        /** 3) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 4) select를 수행할 데이터 생성 */
        Department model = new Department();
        model.setDeptno(deptno);

        /** 5) 데이터 조회 */
        Department result = null;

        try {
            result = sqlSession.selectOne("DepartmentMapper.selectItem", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        /** 6) 결과 판별 */
        if (result == null) {
            logger.debug("조회결과 없음");
        } else {
            logger.debug(result.toString());
        }

        /** 7) DB 접속 해제 */
        sqlSession.commit();
        sqlSession.close();
    }
}
