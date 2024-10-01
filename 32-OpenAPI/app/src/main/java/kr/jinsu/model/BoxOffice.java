package kr.jinsu.model;

import java.util.List;

import lombok.Data;

@Data
public class BoxOffice {
    private BoxOfficeResult boxOfficeResult;

    @Data
    public class BoxOfficeResult {
        private String boxOfficeType;
        private String showRange;
        private List<DailyBoxOfficeList> dailyBoxOfficeList;

        @Data
        public class DailyBoxOfficeList {
            private String movieNm;
            private long audiCnt;
        }
    }
}
