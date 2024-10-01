package kr.jinsu.service;

import java.util.List;

import kr.jinsu.model.Professor;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProfessorService {
    public static final String BASE_URL = "http://localhost:3001";


    /**
     * 학과 정보 저장
     * @param name      학과이름
     * @param userid    닉네임
     * @param position  직위
     * @param sal       월급
     * @param hiredate  입사일
     * @param comm      수수료
     * @param deptno    강의실번호
     * @return          Professor 객체
     */
    @FormUrlEncoded         //post, put, delete 방식 전송일 경우 명시
    @POST("/professor")    //데이터 저장 요청
    Call<Professor> addProfessor(@Field(value = "name", encoded = true) String name,
                                 @Field(value = "userid", encoded = true) String userid,
                                 @Field(value = "position", encoded = true) String position,
                                 @Field(value = "sal", encoded = true) int sal,
                                 @Field(value = "hiredate", encoded = true) String hiredate,
                                 @Field(value = "comm", encoded = true) int comm,
                                 @Field(value = "deptno", encoded = true) int deptno);


    /**
     * 교수 정보 조회
     * @param id        조회할 교수 번호
     * @param userid    닉네임
     * @param position  직위
     * @param sal       월급
     * @param hiredate  입사일
     * @param comm      수수료
     * @param deptno    강의실번호
     * @return          Professor 객체
     */                        
    @GET("/professor/{id}")
    Call<Professor> getProfessor(@Path("id") int id);

    /**
     * 교수 정보 수정(keyweor를 포함하는 목록조회)
     * @param position  직위이름
     * @return  professor List 객체
     */
    @GET("/professor")
    Call<List<Professor>> listProfessor(@Query("position_like") String position);

    /**
     * 교수 정보 수정
     * @param id    
     * @param name
     * @param userid
     * @param position
     * @param sal
     * @param hiredate
     * @param comm
     * @param deptno
     * @return
     */
    @FormUrlEncoded
    @PUT("/professor/{id}")
    Call<Professor> updateProfessor(@Path("id") int id,
                                    @Field("name") String name,
                                    @Field("userid") String userid,
                                    @Field("position") String position,
                                    @Field("sal") int sal,
                                    @Field("hiredate") String hiredate,
                                    @Field("comm") int comm,
                                    @Field("deptno") int deptno);
    /**
     * 학과 정보 삭제
     * @param id    학과번호
     * @return      professor 객체
     */
    @DELETE("/professor/{id}")
    Call<Professor> deleteProfessor(@Path("id") int id);
}
