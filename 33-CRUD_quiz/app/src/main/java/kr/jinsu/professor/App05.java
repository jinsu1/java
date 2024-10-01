package kr.jinsu.professor;

import java.util.Scanner;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.Professor;
import kr.jinsu.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("삭제할 교수 번호: ");
        int id = scanner.nextInt();

        scanner.close();

        //retrofit 객체 생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);

        //Post 전송을 위한 서비스 객체 호출 --> 데이터 저장
        ProfessorService ProfessorService = retrofit.create(ProfessorService.class);
        Call<Professor> call = ProfessorService.deleteProfessor(id);

        call.enqueue(new Callback<Professor>() {

           @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if(response.isSuccessful()) {
                    System.out.println("삭제 성공");
                } else {
                    System.out.println("삭제 실패");
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