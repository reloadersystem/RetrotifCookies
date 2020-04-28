package com.reloader.retrotifcookies.networking;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndPoint {


    @FormUrlEncoded
    @POST("users/login")
    Call<ResponseBody> postRegistrarUsuario(@Field("email") String email,
                                            @Field("password") String password);


}
