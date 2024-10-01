package kr.jinsu.professor;

import java.util.Scanner;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.Professor;
import kr.jinsu.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //문자열 -> 숫자 순으로 입력 받아야한다
        System.out.print("조회할 교수 번호: ");
        int id = scanner.nextInt();

        scanner.close();

        //retrofit 객체 생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);

        ProfessorService ProfessorService = retrofit.create(ProfessorService.class);
        Call<Professor> call = ProfessorService.getProfessor(id);

        call.enqueue(new Callback<Professor>() {

           @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if(response.isSuccessful()) {
                    Professor Professor = response.body();
                    System.out.println("조회된 교수 정보: " + Professor);
                } else {
                    System.out.println("조회 실패");
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