package kr.jinsu.openapi_ex;

import java.util.List;
import java.util.Scanner;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.KakaoImage;
import kr.jinsu.model.KakaoImage.Document;
import kr.jinsu.service.KakaoSearchService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색어를 입력하세요: ");
        String keyword = scanner.nextLine();
        scanner.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("https://dapi.kakao.com");
        
        KakaoSearchService service = retrofit.create(KakaoSearchService.class);

        Call<KakaoImage> call = service.searchImage(keyword);

        call.enqueue(new Callback<KakaoImage>() {
            @Override
            public void onResponse(Call<KakaoImage> call, Response<KakaoImage> response) {
                KakaoImage kakaoImage = response.body();
                List<Document> list = kakaoImage.getDocuments();

                for (Document item : list) {
                    System.out.printf("이미지 URL: %s\n", item.getImageUrl());
                    System.out.printf("썸네일 URL: %s\n", item.getThumbnailUrl());
                    System.out.printf("문서 URL: %s\n", item.getDocUrl());
                    System.out.printf("출처: %s\n", item.getDisplayStiename());
                    System.out.printf("가로: %d, 세로: %d\n", item.getWidth(), item.getHeight());
                    System.out.println();
                }
            }

            @Override
            public void onFailure(Call<KakaoImage> call, Throwable t) {
                System.out.println("통신 에러 발생~!!");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
