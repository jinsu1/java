package kr.jinsu1.model;

public class Data02 {
    private String title;
    private String description;
    private String pubData;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubData() {
        return this.pubData;
    }

    public void setPubData(String pubData) {
        this.pubData = pubData;
    }

    @Override
    public String toString() {
        return "Data02 [title=" + title + ", description" + description + ", pubData=" + pubData + "]";
     }
}
