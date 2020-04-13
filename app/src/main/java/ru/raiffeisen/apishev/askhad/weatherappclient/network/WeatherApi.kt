package ru.raiffeisen.apishev.askhad.weatherappclient.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.raiffeisen.apishev.askhad.weatherappclient.network.dto.Response

const val BASE_URL = "https://cto-weather-app.herokuapp.com/"

interface WeatherApi {

    @GET("city")
    suspend fun getTemp(@Query("name") name: String): Response

    companion object Factory {
        fun create(): WeatherApi {
            val stethoClient = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(stethoClient)
                .build()
            return retrofit.create(WeatherApi::class.java)
        }
    }

}