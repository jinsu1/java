package kr.jinsu1.gson_ex;

import java.util.List;

import com.google.gson.Gson;

import kr.jinsu1.helpers.FileHelper;
import kr.jinsu1.model.Data03;

public class App03 {
    public static void main(String[] args) {
        String json = null;

        try {
            json = FileHelper.getInstance().readString("res/03.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Gson gson = new Gson();
        Data03 data = gson.fromJson(json, Data03.class);
        // System.out.println(data.toString());

        List<String> items = data.getItem();

        // java의 향상된 for문: for-each
        for (String item : items) {
            System.out.println(item);
        }
    }
}
