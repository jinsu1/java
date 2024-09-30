package kr.jinsu.lombok_ex;

import com.google.gson.Gson;
import kr.jinsu.helpers.FileHelper;
import kr.jinsu.model.Data04;

public class App04 {
    public static void main(String[] args) {
        String json = null;

        try {
            json = FileHelper.getInstance().readString("res/04.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Gson gson = new Gson();
        Data04 data = gson.fromJson(json, Data04.class);
        System.out.println(data.toString());
    }
    
}
