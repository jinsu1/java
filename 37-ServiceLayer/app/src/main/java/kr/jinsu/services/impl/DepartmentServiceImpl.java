package kr.jinsu.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.jinsu.exceptions.ServiceNoResultException;
import kr.jinsu.models.Department;
import kr.jinsu.models.Professor;
import kr.jinsu.models.Student;
import kr.jinsu.services.DepartmentService;

/**
 * 학과 관리 기능과 관련된 MyBatis Mapper를 간접적으로 호출하기 위한 기능 명세
 * 
 * (1) 모든 메서드를 재정의 한 직후 리턴값 먼저 정의
 */
public class DepartmentServiceImpl implements DepartmentService {

    private SqlSession sqlSession;

    public DepartmentServiceImpl (SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Department addItem(Department params) throws ServiceNoResultException, Exception {
        Department result = null;

        int rows = sqlSession.insert("DepartmentMapper.insert", params);

        if(rows == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }

        result = sqlSession.selectOne("DepartmentMapper.selectItem", params);

        return result;
    }

    @Override
    public Department editItem(Department params) throws ServiceNoResultException, Exception {
        Department result = null;

        int rows = sqlSession.update("DepartmentMapper.update", params);

        if(rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다.");
        }

        result = sqlSession.selectOne("DepartmentMapper.selectItem", params);

        return result;
    }

    @Override
    public int deleteItem(Department params) throws ServiceNoResultException, Exception {
        int result = 0;

        //학과 데이터 삭제를 위해 참조관계에 있는 자식 데이터를 순서대로 삭제
        Student student = new Student();
        student.setDeptno(params.getDeptno());
        sqlSession.delete("StudentMapper.deleteByDeptno", student);

        Professor professor = new Professor();
        professor.setDeptno(params.getDeptno());
        sqlSession.delete("ProfessorMapper.deleteByDeptno", professor);

        // delete문 수행 --> 리턴되는 값은 수정된 데이터의 수
        result = sqlSession.delete("DepartmentMapper.delete", params);

        if(result == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
        }

        return result;
    }

    @Override
    public Department getItem(Department params) throws ServiceNoResultException, Exception {
        Department result = null;

        result = sqlSession.selectOne("DepartmentMapper.selectItem", params);

        if(result == null) {
            throw new ServiceNoResultException("조회된 데이터가 없습니다.");
        }

        return result;
    }

    @Override
    public List<Department> getList(Department params) throws ServiceNoResultException, Exception {
        return sqlSession.selectList("DepartmentMapper.selectList", params);
    }
}
