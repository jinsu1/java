package kr.jinsu.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kr.jinsu.MyBatisConnectionFactory;
import kr.jinsu.models.Professor;

public class App01_prof {
    public static void main(String[] args) {
        /** (new) Log4j2 객체 생성 */ 
        //Logger logger = LogManager.getLogger("내가만든거");
        Logger logger = LogManager.getLogger(App01_prof.class);

        /** 1) 저장할 데이터 입력받기 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("교수이름: ");
        String name = scanner.nextLine();

        System.out.print("아이디: ");
        String userid = scanner.nextLine();

        System.out.print("직위: ");
        String position = scanner.nextLine();

        System.out.print("입사일: ");
        String hiredate = scanner.nextLine();

        System.out.print("월급: ");
        int sal = scanner.nextInt();

        System.out.print("추가수당: ");
        Integer comm= scanner.nextInt();

        System.out.print("학과번호: ");
        int deptno = scanner.nextInt();

        scanner.close();

        //입력값을 로그로 기록함
        logger.debug("입력된 데이터: " + name + ", " + userid + ", " + userid + ", " + position + ", " + sal + ", " + hiredate + ", " + comm + ", " + deptno);

        /** 2) 데이터베이스 접속 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 3) insert를 수행할 데이터 생성 */
        // --> Beans에 생성자를 사용하지 않으면 필요한 데이터만 setter로 추가할 수 있다.
        Professor professor = new Professor();
        professor.setName(name);
        professor.setUserid(userid);
        professor.setPosition(position);
        professor.setSal(sal);
        professor.setHiredate(hiredate);
        professor.setComm(comm);
        professor.setDeptno(deptno);

        // 4) 데이터 저장
        int result = 0;

        try {
            sqlSession.insert("ProfessorMapper.insert", professor);
            //이 때, 저장할 데이터를 담고 있는 Beans를 파라미터로 전달하고, 자동으로 생성된 PK는 Beans에 저장된다.
            result = professor.getProfno();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        /** 5) 결과판별 */
        // --> 리턴값이 0이라면 내부적으로 예외가 발생된 상황으로 간주해야 한다.
        logger.info(result + "번 데이터 저장됨");

        /** 6) DB 접속 해제 */
        // 페이지 종료 전에 데이터의 변경사항을 저장(commit)하고 데이터베이스 접속  해제하기
        sqlSession.commit();
        sqlSession.close();
    }
}
