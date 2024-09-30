package kr.jinsu.retrofit_ex;

import java.util.List;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.Titanic;
import kr.jinsu.service.MyDataService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App02 {
    public static void main(String[] args) {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MyDataService service = retrofit.create(MyDataService.class);

        Call<List<Titanic>> call = service.getTitanic();

        call.enqueue(new Callback<List<Titanic>>() {
            @Override
            public void onResponse(Call<List<Titanic>> call, Response<List<Titanic>> response) {
                List<Titanic> list = response.body();

                for(Titanic d : list) {
                    System.out.println(d);
                }
            }

            @Override
            public void onFailure(Call<List<Titanic>> call, Throwable t) {
                System.out.println("[통신 에러 발생~!!]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
