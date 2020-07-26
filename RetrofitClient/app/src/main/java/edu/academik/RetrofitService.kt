package edu.academik

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitService  {


    companion object {


        var baseUrl : String = "http://192.168.43.171:8080/clase04.jsf001-1.0.0/rest/"


        private lateinit var retrofit : Retrofit


        fun init () {

            val httpClient = OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->

                val original = chain.request()

                val request = original.newBuilder()
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body())
                    .build()

                chain.proceed(request)
            }).connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)


            val mapper = ObjectMapper()
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            this.retrofit = Retrofit.Builder().baseUrl(this.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build()
        }



        fun <S> createService(serviceClass: Class<S>): S {
            return this.retrofit.create(serviceClass)
        }

    }
}