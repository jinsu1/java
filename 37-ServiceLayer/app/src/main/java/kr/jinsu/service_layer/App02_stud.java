package kr.jinsu.service_layer;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.exceptions.ServiceNoResultException;
import kr.jinsu.models.Student;
import kr.jinsu.services.StudentService;
import kr.jinsu.services.impl.StudentServiceImpl;

public class App02_stud {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App02_prof.class);

        /** 2) 저장할 데이터 입력받기 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 학생 번호: ");
        int studno = scanner.nextInt();

        scanner.close();

        /** 3) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 4) delete를 수행할 데이터 생성 */
        Student stud = new Student();
        stud.setStudno(studno);

        StudentService studentService = new StudentServiceImpl(sqlSession);

        /** 5) 데이터 삭제 */
        int result = 0;

        try {
            result = studentService.deleteItem(stud);
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