package kr.jinsu.service_layer;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.exceptions.ServiceNoResultException;
import kr.jinsu.models.Professor;
import kr.jinsu.services.ProfessorService;
import kr.jinsu.services.impl.ProfessorServiceImpl;

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
        Professor prof = new Professor();
        prof.setProfno(profno);

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

        /** 5) 데이터 삭제 */
        int result = 0;

        try {
            result = professorService.deleteItem(prof);
        }catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[삭제된 데이터가 없습니다.]");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("[SQL문 처리에 실패했습니다. Mapper를 확인하세요.]");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        /** 처리 결과 출력 */
        logger.debug(result + "====================");
        logger.debug(result + "개의 데이터 삭제 완료");
        logger.debug(result + "====================");
        sqlSession.close();
    }
}