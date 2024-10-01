package kr.jinsu.crud_ex;

import java.util.List;
import java.util.Scanner;

import kr.jinsu.helpers.RetrofitHelper;
import kr.jinsu.model.Department;
import kr.jinsu.service.DepartmentService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("검색할 학과 이름: ");
        String keyword = scanner.nextLine();

        scanner.close();

        //retrofit 객체 생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(DepartmentService.BASE_URL);

        //Post 전송을 위한 서비스 객체 호출 --> 데이터 저장
        DepartmentService departmentService = retrofit.create(DepartmentService.class);
        Call<List<Department>> call = departmentService.listDepartment(keyword);

        call.enqueue(new Callback<List<Department>>() {

           @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                if(response.isSuccessful()) {
                    List<Department> department = response.body();

                    for (Department d : department) {
                        System.out.println(d);
                    }
                } else {
                    System.out.println("조회 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                System.out.println("서버 연결 실패: " + t.getMessage());
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
