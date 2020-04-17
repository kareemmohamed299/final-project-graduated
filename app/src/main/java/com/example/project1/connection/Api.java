package com.example.project1.connection;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @POST("api/student")
    public Call<student> getdata(@Body HashMap<Object, Object> map);
    @GET("api/course")
    public Call<cource> courcedata(@Query("code")String code);
    @GET("api/getquestion")
    public Call<List<exam>> mcq_question(@Query("id_exam")String id);
    @GET("api/getmatchController")
    public Call<List<match>> match_question(@Query("id_exam")String id);
    @POST("api/users")
    public Call<doctor>getdoctordata(@Body HashMap<Object,Object>map);
    @POST("api/studentdoctor")
    public Call<List<student_doctor>> getstudent_doctor(@Query("course_code")String course_code,
                                                     @Query("users_id")String users_id);
}
