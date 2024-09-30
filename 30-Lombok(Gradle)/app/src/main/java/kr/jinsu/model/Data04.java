package kr.jinsu.model;

import lombok.Data;

@Data
public class Data04 {
    private Rss rss;

    @Data
    public class Rss {
        private Item item;

        @Data
        public class Item {
            private String title;
            private String description;
            private String pubDate;

        }
    }
}
