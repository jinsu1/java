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

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

        /** 5) 데이터 조회 */
        Department result = null;

        try {
            result = departmentService.getItem(model);
        }  catch (ServiceNoResultException e) {
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
        /** 6) 결과 판별 */
        logger.debug("==========================");

        if(result != null) {
            logger.debug("학과 번호: " + result.getDeptno());
            logger.debug("학과 이름: " + result.getDname());
            logger.debug("위치: " + result.getLoc());
        } else {
            logger.debug("조회된 데이터가 없습니다.");
        }

        logger.debug("==========================");

        /** 7) DB 접속 해제 */
        sqlSession.close();
     }
 }
