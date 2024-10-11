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

public class App03_stud {
    public static void main(String[] args) {
        /** 1) Log4j2 객체 생성 */
        Logger logger = LogManager.getLogger(App03_stud.class);

        /** 2) 수정할 데이터 입력받기 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("수정할 학생이름: ");
        String name = scanner.nextLine();

        System.out.print("수정할 아이디: ");
        String userid = scanner.nextLine();

        System.out.print("수정할 주민번호: ");
        String idnum = scanner.nextLine();

        System.out.print("수정할 생년월일: ");
        String birthdate = scanner.nextLine();

        System.out.print("수정할 연락처: ");
        String tel = scanner.nextLine();

        System.out.print("수정할 학년: ");
        int grade = scanner.nextInt();

        System.out.print("수정할 키: ");
        int height = scanner.nextInt();

        System.out.print("수정할 몸무게: ");
        int weight = scanner.nextInt();

        System.out.print("수정할 학과번호: ");
        int deptno = scanner.nextInt();

        System.out.print("수정할 교수번호: ");
        int profno = scanner.nextInt();
        
        System.out.print("수정사항을 적용할 학생번호: ");
        int studno = scanner.nextInt();

        scanner.close();

        /** 3) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 4) update를 수행할 데이터 생성 */
       Student stud = new Student();
        stud.setStudno(studno);
        stud.setName(name);
        stud.setUserid(userid);
        stud.setGrade(grade);
        stud.setIdnum(idnum);
        stud.setBirthdate(birthdate);
        stud.setTel(tel);
        stud.setHeight(height);
        stud.setWeight(weight);
        stud.setDeptno(deptno);
        stud.setProfno(profno);

        StudentService studentService = new StudentServiceImpl(sqlSession);
        Student result = null;

    
        try {
            result = studentService.editItem(stud);
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
            logger.debug("학생 번호: " + result.getStudno());
            logger.debug("아이디: " + result.getUserid());
            logger.debug("주민번호: " + result.getIdnum());
            logger.debug("생년월일: " + result.getBirthdate());
            logger.debug("연락처: " + result.getTel());
            logger.debug("학년: " + result.getGrade());
            logger.debug("키: " + result.getHeight());
            logger.debug("몸무게: " + result.getWeight());
            logger.debug("학과번호: " + result.getDeptno());
            logger.debug("교수번호: " + result.getProfno());
            

        } else {
            logger.debug("수정된 데이터가 없습니다.");
        }

        logger.debug("==========================");

        /** 7) DB 접속 해제 */
        sqlSession.close();
    }
}
