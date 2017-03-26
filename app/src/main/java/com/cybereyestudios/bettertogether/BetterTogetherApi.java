package com.cybereyestudios.bettertogether;

import com.google.gson.JsonElement;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Samuel Rabinowitz on 3/25/2017.
 */

public interface BetterTogetherApi {

    @POST("signup.php")
    @FormUrlEncoded
    Call<JsonElement> signUp(@Field("email") String email,
                             @Field("password") String password,
                             @Field("username") String username,
                             @Field("phone") String phone
    );

    @POST("signin.php")
    @FormUrlEncoded
    Call<JsonElement> signIn(@Field("email") String email,
                             @Field("password") String password
    );

}
