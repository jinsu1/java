package kr.jinsu1.model;

import java.util.List;

public class Data03 {
    private List<String> item;

    public List<String> getItem() {
        return item;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Data03 [item=" + item + "]";
    }
}
