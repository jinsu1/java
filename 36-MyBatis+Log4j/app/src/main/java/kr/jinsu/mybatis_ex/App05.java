package kr.jinsu.mybatis_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.models.Department;

public class App05 {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App05.class);

        /** 2) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 3) 데이터 조회 */
        List<Department> result = null;

        try {
            // DepartmentMapper라는 namespace를 갖는 XML에서 id값이 selectList인 <select> 태그를 호출한다.
            // 이 때, 조회할 데이터를 담고 있는 Beans를 파라미터로 전달하고, 결과를 List<Beans>로 받는다.
            // 전달할 파라미터가 없는 경우 beans를 null로 설정한다.
            result = sqlSession.selectList("DepartmentMapper.selectList", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        /** 4) 결과 판별 */
        if (result == null) {
            logger.debug("조회결과 없음");
        } else {
            for (int i = 0; i < result.size(); i++) {
                Department item = result.get(i);

                logger.debug("학과번호: " + item.getDeptno());
                logger.debug("학과명: " + item.getDname());
                logger.debug("위치: " + item.getLoc());
            }
        }

        /** 7) DB 접속 해제 */
        sqlSession.close();
    }
}
