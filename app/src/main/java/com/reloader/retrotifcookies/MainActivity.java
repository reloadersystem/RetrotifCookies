package com.reloader.retrotifcookies;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.reloader.retrotifcookies.networking.EndPoint;
import com.reloader.retrotifcookies.networking.MethodWs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EndPoint endPoint = MethodWs.getConfiguration().create(EndPoint.class);
        Call<ResponseBody> responseBodyCall = endPoint.postRegistrarUsuario("a@a.com", "123456");

        responseBodyCall.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                if (response.isSuccessful()) {
                    try {

                        String cookie = response.headers().get("Set-Cookie");
                        Log.v("cookieData", cookie);






                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("infoResponseErrorPost", t.getMessage());
            }
        });
    }
}
