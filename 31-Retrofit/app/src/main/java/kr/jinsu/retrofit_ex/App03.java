package kr.jinsu.retrofit_ex;

import java.util.List;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.Traffic_acc;
import kr.jinsu.service.MyDataService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
    public static void main(String[] args) {
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MyDataService service = retrofit.create(MyDataService.class);

        Call<List<Traffic_acc>> call = service.getTraffic_acc();

        call.enqueue(new Callback<List<Traffic_acc>>() {
            @Override
            public void onResponse(Call<List<Traffic_acc>> call, Response<List<Traffic_acc>> response) {
                List<Traffic_acc> list = response.body();

                for(Traffic_acc d : list) {
                    System.out.println(d);
                }
            }

            @Override
            public void onFailure(Call<List<Traffic_acc>> call, Throwable t) {
                System.out.println("[통신 에러 발생~!!]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
