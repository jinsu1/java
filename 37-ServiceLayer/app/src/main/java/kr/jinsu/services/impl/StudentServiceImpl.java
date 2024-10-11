package kr.jinsu.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.jinsu.exceptions.ServiceNoResultException;
import kr.jinsu.models.Student;
import kr.jinsu.services.StudentService;

/**
 * 학과 관리 기능과 관련된 MyBatis Mapper를 간접적으로 호출하기 위한 기능 명세
 * 
 * (1) 모든 메서드를 재정의 한 직후 리턴값 먼저 정의
 */
public class StudentServiceImpl implements StudentService {

    private SqlSession sqlSession;

    public StudentServiceImpl (SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Student addItem(Student params) throws ServiceNoResultException, Exception {
        Student result = null;

        int rows = sqlSession.insert("StudentMapper.insert", params);

        if(rows == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }

        result = sqlSession.selectOne("StudentMapper.selectItem", params);

        return result;
    }

    @Override
    public Student editItem(Student params) throws ServiceNoResultException, Exception {
        Student result = null;

        int rows = sqlSession.update("StudentMapper.update", params);

        if(rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다.");
        }

        result = sqlSession.selectOne("StudentMapper.selectItem", params);

        return result;
    }

    @Override
    public int deleteItem(Student params) throws ServiceNoResultException, Exception {
        int result = 0;

        // delete문 수행 --> 리턴되는 값은 수정된 데이터의 수
        result = sqlSession.delete("StudentMapper.delete", params);

        if(result == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
        }

        return result;
    }

    @Override
    public Student getItem(Student params) throws ServiceNoResultException, Exception {
        Student result = null;

        result = sqlSession.selectOne("StudentMapper.selectItem", params);

        if(result == null) {
            throw new ServiceNoResultException("조회된 데이터가 없습니다.");
        }

        return result;
    }

    @Override
    public List<Student> getList(Student params) throws ServiceNoResultException, Exception {
        return sqlSession.selectList("StudentMapper.selectList", params);
    }
}
