package kr.jinsu1.model;

import java.util.List;

public class Data05 {
    private Rss rss;

    public Rss getRss() {
        return rss;
    }

    public void setRss(Rss rss) {
        this.rss = rss;
    }

    @Override
    public String toString() {
        return "Data04 [rss=" + rss + "]";
    }

    public class Rss {
        private List<Item> item;
    
        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Rss [item=" + item + "]";
        }

        public class Item {
            private String title;
            private String description;
            private String pubDate;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }              
            public String getDescription() {
                return description;
            }  

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            @Override
            public String toString() {
                return "Item [title=" + title + ", description=" + description + ", pubDate=" + pubDate + "]";
            }
        }
    }
}
