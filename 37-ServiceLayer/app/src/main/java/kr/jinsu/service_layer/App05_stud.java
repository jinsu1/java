package kr.jinsu.service_layer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.exceptions.ServiceNoResultException;
import kr.jinsu.models.Student;
import kr.jinsu.services.StudentService;
import kr.jinsu.services.impl.StudentServiceImpl;

public class App05_stud {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App05_stud.class);

        /** 2) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        StudentService studentService = new StudentServiceImpl(sqlSession);

        /** 3) 데이터 조회 */
        List<Student> result = null;

        try {
            result = studentService.getList(null);
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
                Student item = result.get(i);

                logger.debug("학생 번호: " + item.getStudno());
                logger.debug("아이디: " + item.getUserid());
                logger.debug("주민번호: " + item.getIdnum());
                logger.debug("생년월일: " + item.getBirthdate());
                logger.debug("연락처: " + item.getTel());
                logger.debug("학년: " + item.getGrade());
                logger.debug("키: " + item.getHeight());
                logger.debug("몸무게: " + item.getWeight());
                logger.debug("학과번호: " + item.getDeptno());
                logger.debug("교수번호: " + item.getProfno());

                if( i+1 < result.size()) {
                    logger.debug("---------------------");
                }
            }
        }

        /** 7) DB 접속 해제 */
        sqlSession.close();
    }
}
