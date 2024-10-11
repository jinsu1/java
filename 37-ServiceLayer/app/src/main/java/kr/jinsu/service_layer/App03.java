package kr.jinsu.service_layer;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.exceptions.ServiceNoResultException;
import kr.jinsu.models.Department;
import kr.jinsu.services.DepartmentService;
import kr.jinsu.services.impl.DepartmentServiceImpl;

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

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);
        Department result = null;

    
        try {
            result = departmentService.editItem(model);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[수정된 데이터가 없습니다.]");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("[SQL문 처리에 실패했습니다. Mapper를 확인하세요.]");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        /** 6) 결과 판별 */
        logger.debug("==========================");

        if(result != null) {
            logger.debug("학과 번호: " + result.getDeptno());
            logger.debug("학과 이름: " + result.getDname());
            logger.debug("위치: " + result.getLoc());
        } else {
            logger.debug("수정된 데이터가 없습니다.");
        }

        logger.debug("==========================");

        /** 7) DB 접속 해제 */
        sqlSession.close();
    }
}
