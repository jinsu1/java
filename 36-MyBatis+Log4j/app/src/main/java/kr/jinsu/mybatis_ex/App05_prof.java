package kr.jinsu.mybatis_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.models.Professor;

public class App05_prof {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App05_prof.class);

        /** 2) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 3) 데이터 조회 */
        List<Professor> result = null;

        try {
            // ProfessorMapper라는 namespace를 갖는 XML에서 id값이 selectList인 <select> 태그를 호출한다.
            // 이 때, 조회할 데이터를 담고 있는 Beans를 파라미터로 전달하고, 결과를 List<Beans>로 받는다.
            // 전달할 파라미터가 없는 경우 beans를 null로 설정한다.
            result = sqlSession.selectList("ProfessorMapper.selectList", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        /** 4) 결과 판별 */
        if (result == null) {
            logger.debug("조회결과 없음");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Professor item = result.get(i);

                logger.debug("교수번호: " + item.getProfno());
                logger.debug("교수명: " + item.getName());
                logger.debug("아이디: " + item.getUserid());
                logger.debug("직위: " + item.getPosition());
                logger.debug("월급: " + item.getSal());
                logger.debug("입사일: " + item.getHiredate());
                logger.debug("추가수당: " + item.getComm());
                logger.debug("학과번호: " + item.getDeptno());
                logger.debug(" ");
            }
        }

        /** 7) DB 접속 해제 */
        sqlSession.close();
    }
}
