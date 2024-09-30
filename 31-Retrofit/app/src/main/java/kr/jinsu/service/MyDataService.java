package kr.jinsu.service;

import java.util.List;

import kr.jinsu.model.Traffic_acc;
import kr.jinsu.model.Titanic;
import kr.jinsu.model.Grade;
import kr.jinsu.model.News;
import retrofit2.Call;
import retrofit2.http.GET;


public interface MyDataService {

    @GET("/news")
    Call<List<News>> getNews();

    @GET("/titanic")
    Call<List<Titanic>> getTitanic();

    @GET("/traffic_acc")
    Call<List<Traffic_acc>> getTraffic_acc();

    @GET("/grade")
    Call<List<Grade>> getGrade();
}