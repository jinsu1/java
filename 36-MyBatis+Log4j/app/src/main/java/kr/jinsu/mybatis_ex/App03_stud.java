package kr.jinsu.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.models.Student;

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
        Student model = new Student();
        model.setName(name);
        model.setUserid(userid);
        model.setGrade(grade);
        model.setIdnum(idnum);
        model.setBirthdate(birthdate);
        model.setTel(tel);
        model.setHeight(height);
        model.setWeight(weight);
        model.setDeptno(deptno);
        model.setProfno(profno);
        model.setStudno(studno);


        /** 5) 데이터 수정 */
        int result = 0;
        try {
            result = sqlSession.update("StudentMapper.update", model);

            if (result == 0) {
                throw new Exception("수정된 데이터가 없습니다.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        /** 6) 결과 판별 */
        logger.debug(result + "개의 데이터 수정됨");

        /** 7) DB 접속 해제 */
        sqlSession.commit();
        sqlSession.close();
    }
}
