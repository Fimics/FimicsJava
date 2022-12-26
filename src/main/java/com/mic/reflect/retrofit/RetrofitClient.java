package com.mic.reflect.retrofit;

import com.mic.reflect.retrofit.api.EnjoyWeatherApi;
import com.mic.reflect.retrofit.api.WeatherApi;
import com.mic.reflect.retrofit.retrofit.EnjoyRetrofit;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class RetrofitClient {

    private static WeatherApi weatherApi;
    private static EnjoyWeatherApi enjoyWeatherApi;

    static {
        String baseUrl ="https://restapi.amap.com";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).build();
        weatherApi=retrofit.create(WeatherApi.class);

        EnjoyRetrofit enjoyRetrofit = new EnjoyRetrofit.Builder().baseUrl(baseUrl).build();
        enjoyWeatherApi = enjoyRetrofit.create(EnjoyWeatherApi.class);
    }

    public static void main(String[] args) {
         RetrofitClient client = new RetrofitClient();
//         client.get();
           client.enjoyGet();
    }

    public void get() {
        Call<ResponseBody> call = weatherApi.getWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    ResponseBody body = response.body();
                    try {
                        String string = body.string();
                        System.out.println("onResponse get: " + string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        body.close();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }

    public void post() {
        Call<ResponseBody> call = weatherApi.postWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody body = response.body();
                try {
                    String string = body.string();
                    System.out.println( "onResponse post: " + string);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    body.close();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void enjoyGet() {
        okhttp3.Call call = enjoyWeatherApi.getWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                System.out.println("onResponse enjoy get: " + response.body().string());
                response.close();
            }
        });

    }

    public void enjoyPost() {
        okhttp3.Call call = enjoyWeatherApi.postWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                System.out.println("onResponse enjoy post: " + response.body().string());
                response.close();
            }
        });
    }
}
