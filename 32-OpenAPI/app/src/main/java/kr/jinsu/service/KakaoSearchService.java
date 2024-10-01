package kr.jinsu.service;

import kr.jinsu.model.KakaoImage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface KakaoSearchService {
    @Headers({"Authorization: KakaoAK 48300ed01d5822f850073b1b4134187d"})
    @GET("/v2/search/image")
    Call<KakaoImage> searchImage(@Query("query") String query);
}
