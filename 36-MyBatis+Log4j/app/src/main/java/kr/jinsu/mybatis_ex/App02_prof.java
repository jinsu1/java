package kr.jinsu.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.models.Professor;

public class App02_prof {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App02_prof.class);

        /** 2) 저장할 데이터 입력받기 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 교수 번호: ");
        int profno = scanner.nextInt();

        scanner.close();

        /** 3) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 4) delete를 수행할 데이터 생성 */
        Professor model = new Professor();
        model.setProfno(profno);

        /** 5) 데이터 삭제 */
        int result = 0;
        try {
            result = sqlSession.delete("ProfessorMapper.delete", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        /** 6) 결과 판별 */
        logger.debug(result + "개의 데이터 삭제됨");

        /** 7) DB 접속 해제 */
        sqlSession.commit();
        sqlSession.close();
    }
}
