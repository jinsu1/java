package kr.jinsu.professor;

import java.util.Scanner;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.Professor;
import kr.jinsu.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //문자열 -> 숫자 순으로 입력 받아야한다
        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("아이디: ");
        String userid = scanner.nextLine();

        System.out.print("직위: ");
        String position = scanner.nextLine();

        System.out.print("입사일: ");
        String hiredate = scanner.nextLine();

        System.out.print("월급: ");
        int sal = scanner.nextInt();

        System.out.print("수수료: ");
        int comm = scanner.nextInt();

        System.out.print("강의실: ");
        int deptno = scanner.nextInt();

        scanner.close();

        //retrofit 객체 생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);

        //Post 전송을 위한 서비스 객체 호출 --> 데이터 저장
        ProfessorService ProfessorService = retrofit.create(ProfessorService.class);
        Call<Professor> call = ProfessorService.addProfessor(name, userid, position, sal, hiredate, comm, deptno);

        call.enqueue(new Callback<Professor>() {

           @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if(response.isSuccessful()) {
                    Professor Professor = response.body();
                    System.out.println("저장된 학과 정보: " + Professor);
                } else {
                    System.out.println("저장 실패");
                }
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                System.out.println("서버 연결 실패: " + t.getMessage());
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}