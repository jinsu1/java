package kr.jinsu.openapi_ex;

import java.util.List;
import java.util.Scanner;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.BoxOffice;
import kr.jinsu.model.BoxOffice.BoxOfficeResult.DailyBoxOfficeList;
import kr.jinsu.service.BoxOfficeService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 날짜를 입력하세요(yyyymmdd): ");
        String targetDt = scanner.nextLine();
        scanner.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://www.kobis.or.kr/");
        
        BoxOfficeService service = retrofit.create(BoxOfficeService.class);

        Call<BoxOffice> call = service.getBoxOffice(targetDt);

        call.enqueue(new Callback<BoxOffice>() {
            @Override
            public void onResponse(Call<BoxOffice> call, Response<BoxOffice> response) {
                BoxOffice boxOffice = response.body();
                List<DailyBoxOfficeList> list = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

                for (DailyBoxOfficeList item : list) {
                    System.out.printf("제목: %s\n", item.getMovieNm());
                    System.out.printf("관람객수: %d\n\n", item.getAudiCnt());
                }
            }

            @Override
            public void onFailure(Call<BoxOffice> call, Throwable t) {
                System.out.println("통신 에러 발생~!!");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
