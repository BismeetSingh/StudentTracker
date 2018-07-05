package com.app.laqshya.studenttracker.activity.service;

import com.app.laqshya.studenttracker.activity.model.LoginModel;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EduTrackerService {
    String ENDPOINT = "http://192.168.0.113/student_tracker/";
    @FormUrlEncoded
    @POST("login.php")
    Single<LoginModel> loginUSer(@Field("mobile")String mobile, @Field("password")String password,
                                 @Field("flag")int flag);

}
