package kr.jinsu.service_layer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.exceptions.ServiceNoResultException;
import kr.jinsu.models.Professor;
import kr.jinsu.services.ProfessorService;
import kr.jinsu.services.impl.ProfessorServiceImpl;

public class App05_prof {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App05_prof.class);

        /** 2) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

        /** 3) 데이터 조회 */
        List<Professor> result = null;

        try {
            result = professorService.getList(null);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[조회된 데이터가 없습니다.]");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("[SQL문 처리에 실패했습니다. Mapper를 확인하세요.]");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        /** 4) 결과 판별 */
        if (result == null) {
            logger.debug("조회결과 없음");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Professor item = result.get(i);

                logger.debug("교수 번호: " + item.getProfno());
                logger.debug("아이디: " + item.getUserid());
                logger.debug("교수 이름: " + item.getName());
                logger.debug("직위: " + item.getPosition());
                logger.debug("입사일: " + item.getHiredate());
                logger.debug("월급: " + item.getSal());
                logger.debug("추가수당: " + item.getComm());
                logger.debug("학과번호: " + item.getDeptno());

                if( i+1 < result.size()) {
                    logger.debug("---------------------");
                }
            }
        }

        /** 7) DB 접속 해제 */
        sqlSession.close();
    }
}
