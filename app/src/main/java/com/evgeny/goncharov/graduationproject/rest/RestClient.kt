package com.evgeny.goncharov.graduationproject.rest

import android.util.Log
import com.evgeny.goncharov.graduationproject.consts.BASE_URL
import com.evgeny.goncharov.graduationproject.consts.LOG_REST_MANAGER
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {

    private val retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(getClientMonitorHTTPBody())
            .build()


    private fun getClientMonitorHTTPBody(): OkHttpClient {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(
                HttpLoggingInterceptor.Logger
                { message ->
                    Log.d(LOG_REST_MANAGER, message)
                })

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .connectTimeout(2500, TimeUnit.MILLISECONDS)
                .readTimeout(2500, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .build()
    }



    fun <T : Any> createService(java: Class<T>): T {
        return retrofit.create(java)
    }

}