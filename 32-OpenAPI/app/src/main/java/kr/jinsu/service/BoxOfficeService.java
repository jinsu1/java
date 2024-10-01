package kr.jinsu.service;

import kr.jinsu.model.BoxOffice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BoxOfficeService {
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=abeb353499360f3b88fdd6b34a1ef123")
    Call<BoxOffice> getBoxOffice(@Query("targetDt") String targetDt);
}
