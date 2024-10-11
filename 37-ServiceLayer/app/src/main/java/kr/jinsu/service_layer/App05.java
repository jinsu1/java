package kr.jinsu.service_layer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.exceptions.ServiceNoResultException;
import kr.jinsu.models.Department;
import kr.jinsu.services.DepartmentService;
import kr.jinsu.services.impl.DepartmentServiceImpl;

public class App05 {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App05.class);

        /** 2) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

        /** 3) 데이터 조회 */
        List<Department> result = null;

        try {
            result = departmentService.getList(null);
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
                Department item = result.get(i);

                logger.debug("학과번호: " + item.getDeptno());
                logger.debug("학과명: " + item.getDname());
                logger.debug("위치: " + item.getLoc());

                if( i+1 < result.size()) {
                    logger.debug("---------------------");
                }
            }
        }

        /** 7) DB 접속 해제 */
        sqlSession.close();
    }
}
