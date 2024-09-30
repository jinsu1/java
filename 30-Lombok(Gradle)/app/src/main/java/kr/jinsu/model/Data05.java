package kr.jinsu.model;

import java.util.List;

import lombok.Data;

@Data
public class Data05 {
    private Rss rss;

    @Data
    public class Rss {
        private List<Item> item;

        @Data
        public class Item {
            private String title;
            private String description;
            private String pubDate; 
        }
    }
}
