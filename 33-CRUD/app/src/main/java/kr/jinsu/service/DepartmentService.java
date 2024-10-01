package kr.jinsu.service;

import java.util.List;

import kr.jinsu.model.Department;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DepartmentService {
    public static final String BASE_URL = "http://localhost:3001";

    /**
     * 학과 정보 저장
     * @param dname 학과이름
     * @param loc   위치
     * @return Department 객체
     */
    @FormUrlEncoded         //post, put, delete 방식 전송일 경우 명시
    @POST("/department")    //데이터 저장 요청
    Call<Department> addDepartment(@Field(value = "dname", encoded = true) String dname,
                                    @Field(value = "loc", encoded = true) String loc);

    /**
     * 학과 정보 조회
     * @param id 학과번호
     * @return   Department 객체
     */
    @GET("/department/{id}")
    Call<Department> getDepartment(@Path("id") int id);

    /**
     * 학과 정보 조회(keyweor를 포함하는 목록)
     * @param dname 학과이름
     * @return  Department List 객체
     */
    @GET("/department")
    Call<List<Department>> listDepartment(@Query("dname_like") String dname);

    /**
     * 학과 정보 수정
     * @param id        학과번호
     * @param dname     학과이름
     * @param loc       위치
     * @return          Department 객체
     */
    @FormUrlEncoded
    @PUT("/department/{id}")
    Call<Department> updateDepartment(@Path("id") int id,
                                      @Field("dname") String dname,
                                      @Field("loc") String loc);
    /**
     * 학과 정보 삭제
     * @param id    학과번호
     * @return      Department 객체
     */
    @DELETE("/department/{id}")
    Call<Department> deleteDepartment(@Path("id") int id);
}
