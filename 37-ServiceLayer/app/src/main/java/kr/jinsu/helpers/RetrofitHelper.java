package kr.jinsu.helpers;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper current;

    private OkHttpClient httpClient;

    public static RetrofitHelper getInstance() {
        if (current == null) {
            current = new RetrofitHelper();
        }

        return current;
    }

    public static void freeInstance() {
        current = null;
    }

    private RetrofitHelper() {
        super();
    }
    public Retrofit getRetrofit(String baseUrl) {
         //통신 객체를 생성하기 위한 builder 객체 정의 
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        //Builder를 통해 통신객체 생성
        OkHttpClient httpClient = httpClientBuilder.build();

        //Retrofit을 생성하는 기능을 수행하는 객체 정의
        Retrofit.Builder builder = new Retrofit.Builder();

        //기본 주소를 지정
        builder.baseUrl(baseUrl);

        //통신 결과를 Gson 객체를 통해 처리하도록 Gson연결 == > JSON 파싱 자동화
        builder.addConverterFactory(GsonConverterFactory.create());

        //통신객체를 연결
        builder.client(httpClient);

        //모든 설정이 반영된 Retrofit 객체 생성
        Retrofit retrofit = builder.build();
        return retrofit;
    }

    public void shutdown() {
        if(httpClient != null) {
            httpClient.dispatcher().executorService().shutdown();
        }
    }
}
