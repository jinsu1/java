package kr.jinsu.professor;

import java.util.List;
import java.util.Scanner;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.Professor;
import kr.jinsu.service.ProfessorService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("검색할 직위 이름: ");
        String keyword = scanner.nextLine();

        scanner.close();

        //retrofit 객체 생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);

        //Post 전송을 위한 서비스 객체 호출 --> 데이터 저장
        ProfessorService professorService = retrofit.create(ProfessorService.class);
        Call<List<Professor>> call = professorService.listProfessor(keyword);

        call.enqueue(new Callback<List<Professor>>() {

           @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                if(response.isSuccessful()) {
                    List<Professor> professor = response.body();

                    for (Professor d : professor) {
                        System.out.println(d);
                    }
                } else {
                    System.out.println("조회 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                System.out.println("서버 연결 실패: " + t.getMessage());
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
