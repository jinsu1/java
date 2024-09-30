package kr.jinsu.retrofit_ex;

import java.util.List;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.Grade;
import kr.jinsu.service.MyDataService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App04 {
    public static void main(String[] args) {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MyDataService service = retrofit.create(MyDataService.class);

        Call<List<Grade>> call = service.getGrade();

        call.enqueue(new Callback<List<Grade>>() {
            @Override
            public void onResponse(Call<List<Grade>> call, Response<List<Grade>> response) {
                List<Grade> list = response.body();

                for(Grade d : list) {
                    System.out.printf("학번: %d, ", d.getId());
                    System.out.printf("이름: %s, ", d.getName());
                    System.out.printf("학년: %d, ", d.getLevel());
                    System.out.printf("성별: %s, ", d.getSex());
                    System.out.printf("국어: %d, ", d.getKor());
                    System.out.printf("영어: %d, ", d.getEng());
                    System.out.printf("수학: %d, ", d.getMath());
                    System.out.printf("과학: %d\n", d.getSin());
                }
            }

            @Override
            public void onFailure(Call<List<Grade>> call, Throwable t) {
                System.out.println("[통신 에러 발생~!!]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
